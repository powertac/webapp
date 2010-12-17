package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus

class SeriesController {

  def experimentManagementService
  def scaffold = Series

  def resetAll = {
    def seriesInstance = Series.get(params.id)
    if (seriesInstance) {
      def i = experimentManagementService.resetSeries(seriesInstance)
      flash.message = "${i} experiment in series '${seriesInstance}' reset."
      redirect(action: 'show', id: seriesInstance.id)
    } else {
      flash.error = "Series not found with id ${params.id}"
      redirect(action: list)
    }
  }

  def activateAll = {
    def seriesInstance = Series.get(params.id)
    if (seriesInstance) {
      def i = experimentManagementService.activateSeries(seriesInstance)
      flash.message = "${i} experiment in series '${seriesInstance}' activated."
      redirect(action: 'show', id: seriesInstance.id)
    } else {
      flash.error = "Series not found with id ${params.id}"
      redirect(action: list)
    }
  }
}