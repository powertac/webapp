import edu.kit.iism.experimentcenter.WorkerClient
import edu.kit.iism.experimentcenter.enumerations.WorkerStatus
import edu.kit.iism.experimentcenter.Experiment
import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus

class WorkerClientService {

    boolean transactional = false

    def run() {
      log.debug "Running WorkerClientService..."
      def cal = new GregorianCalendar()
      cal.add (Calendar.MINUTE, -3)
      WorkerClient.findAllByLastUpdatedLessThan (cal.getTime()).each {WorkerClient workerClient ->
        workerClient.online = false
        workerClient.workerStatus = WorkerStatus.Unknown
        workerClient.save()
        Experiment.findAllByTargetMachineAndExperimentStatus(workerClient.hostName, ExperimentStatus.Running).each {
          it.experimentStatus = ExperimentStatus.Interrupted
          it.save()
        }
      }
    }
}
