import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus
import edu.kit.iism.experimentcenter.*

class ExperimentManagementService {

  boolean transactional = true

  def delete(Experiment experimentInstance) throws org.springframework.dao.DataIntegrityViolationException {
    deleteReferencedData(experimentInstance.id)
    experimentInstance.delete(flush: true)
  }

  def activateSeries(Series seriesInstance) {
    def i = 0
    seriesInstance?.experiments?.each {experiment ->
      if (experiment.experimentStatus == ExperimentStatus.Paused) {
        experiment.experimentStatus = ExperimentStatus.Pending
        experiment.save()
        i++
      }
    }
    return i
  }


  def resetSeries(Series seriesInstance) {
    def i = 0
    if (seriesInstance) {
      def experiments = Experiment.findAllBySeries(seriesInstance)
      experiments?.each {experimentInstance ->
        reset(experimentInstance)
        i++
      }
    }
    return i
  }

  def reset(Experiment experimentInstance) {
    def experimentCopy = new Experiment(name: experimentInstance.name, description: experimentInstance.description, experimentConfiguration: experimentInstance.experimentConfiguration, experimentStatus: ExperimentStatus.Paused, series: experimentInstance.series).save()
    experimentInstance.series.removeFromExperiments (experimentInstance)
    deleteReferencedData(experimentInstance.id)
    experimentInstance.delete()
    return experimentCopy
  }

  private def deleteReferencedData = {experimentId ->
    TimeslotRating.executeUpdate('delete from TimeslotRating t where t.experiment.id = ?', [experimentId])
    AccountEntry.executeUpdate('delete from AccountEntry a where a.experiment.id = ?', [experimentId])
    Shout.executeUpdate('delete from Shout s where s.experiment.id = ?', [experimentId])
    BlockShout.executeUpdate('delete from BlockShout bs where bs.experiment.id = ?', [experimentId])
    ExperimentError.executeUpdate('delete from ExperimentError e where e.experiment.id=?', [experimentId])
    Quote.executeUpdate('delete from Quote q where q.experiment.id = ?', [experimentId])
    StockEntry.executeUpdate('delete from StockEntry s where s.experiment.id=?', [experimentId])
    Timeslot.executeUpdate('delete from Timeslot t where t.experiment.id=?', [experimentId])
    TradeLog.executeUpdate('delete from TradeLog t where t.experiment.id=?', [experimentId])
    TradingAgent.executeUpdate('delete from TradingAgent t where t.experiment.id=?', [experimentId])
  }
}
