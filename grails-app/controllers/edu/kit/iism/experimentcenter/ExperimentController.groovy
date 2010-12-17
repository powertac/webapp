package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus

class ExperimentController {

  def experimentManagementService
  def scaffold = Experiment

  // the delete, save and update actions only accept POST requests
  static allowedMethods = [delete: ['POST', 'DELETE'], remove: ['POST', 'DELETE'], save: 'POST', update: ['POST', 'UPDATE'], pause: 'POST', activate: 'POST', reset: 'POST', duplicate: 'POST']


  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    if (!params.sort) params.sort = 'id'
    def filter = null
    try {filter = ExperimentStatus.valueOf(params.filter)} catch (Exception e) {
      if (params.filter) flash.message = "Filter '${params.filter}' is invalid."
    }
    def experimentList
    def experimentInstanceTotal
    if (!filter) {
      experimentList = Experiment.list(params)
      experimentInstanceTotal = Experiment.count()
    } else {
      experimentList = Experiment.findAllByExperimentStatus(filter)
      experimentInstanceTotal = Experiment.countByExperimentStatus(filter)
    }
    [experimentInstanceList: experimentList, experimentInstanceTotal: experimentInstanceTotal, params: params]
  }



  def delete = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      try {
        experimentManagementService.delete(experimentInstance)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'experiment.label', default: 'Experiment'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'experiment.label', default: 'Experiment'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experiment.label', default: 'Experiment'), params.id])}"
      redirect(action: "list")
    }
  }


  def update = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (experimentInstance.version > version) {

          experimentInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'experiment.label', default: 'Experiment')] as Object[], "Another user has updated this Experiment while you were editing")
          render(view: "edit", model: [experimentInstance: experimentInstance])
          return
        }
      }
      if (params.series?.id == '-1') {
        bindData (experimentInstance, params, [exclude:['series','series.id']])
        experimentInstance.series.removeFromExperiments(experimentInstance)
        experimentInstance.series = null
      } else {
        experimentInstance.properties = params
      }
      if (!experimentInstance.hasErrors() && experimentInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'experiment.label', default: 'Experiment'), experimentInstance.id])}"
        redirect(action: "show", id: experimentInstance.id)
      }
      else {
        render(view: "edit", model: [experimentInstance: experimentInstance])
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'experiment.label', default: 'Experiment'), params.id])}"
      redirect(action: "list")
    }
  }

  def get = {
    def workerClient = WorkerClient.findByHostName(params.id)
    if (!workerClient?.enabled) {
      render(contentType: "text/xml") {
        info {
          message("This worker client was (temprorarily) disabled in the experiment center...")
        }
      }
    } else {
      Double workerAppVersion = null
      try {workerAppVersion = Double.valueOf(workerClient.appVersion)} catch (Exception e) {}
      List experimentInstances = Experiment.withCriteria {
        eq('experimentStatus', ExperimentStatus.Pending)
        if (workerAppVersion) {
          le('minVersionExperimentRunner', workerAppVersion)
          ge('maxVersionExperimentRunner', workerAppVersion)
        }
        lock: true
      }
      if (experimentInstances?.size() > 0) {
        def experimentInstance = experimentInstances.first()
        experimentInstance.experimentStatus = ExperimentStatus.Running
        if (params.id) experimentInstance.targetMachine = params.id
        experimentInstance.save(flush: true)
        render(contentType: "text/xml") {
          experiment {
            id(experimentInstance.id)
            name(experimentInstance.name)
            experimentConfiguration(experimentInstance.experimentConfiguration)
          }
        }
      } else {
        render(contentType: "text/xml") {
          info {
            message("Currently there are no pending experiments.")
          }
        }
      }
    }
  }

  //REST method that interpretes a http DELETE request as "experiment finished" and thus sets the experiment to status "finished"
  def remove = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      experimentInstance.experimentStatus = ExperimentStatus.Finished
      experimentInstance.save(flush: true)
      render(contentType: "text/xml") {
        info {
          message("Experiment ${params.id} is now finished.")
        }
      }
    } else {
      render(contentType: "text/xml") {
        error {
          message("The ExperimentID provided does not exist or is invalid.")
        }
      }
    }
  }

  def pause = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      experimentInstance.experimentStatus = ExperimentStatus.Paused
      experimentInstance.save()
      flash.message = "Experiment ${experimentInstance} paused"
    } else {
      flash.error = "Experiment not found with id ${params.id}"
    }
    redirect(action: list)
  }

  def activate = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      experimentInstance.experimentStatus = ExperimentStatus.Pending
      experimentInstance.save()
      flash.message = "Experiment ${experimentInstance} activated"
    } else {
      flash.error = "Experiment not found with id ${params.id}"
    }
    redirect(action: list)
  }

  def reset = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      def experimentCopy = experimentManagementService.reset(experimentInstance)
      flash.message = "Experiment successfully reset."
      redirect(action: show, id: experimentCopy.id)
    } else {
      flash.error = "Experiment not found with id ${params.id}"
      redirect(action: list)
    }
  }

  def duplicate = {
    def experimentInstance = Experiment.get(params.id)
    if (experimentInstance) {
      def experimentCopy = new Experiment(series: experimentInstance.series, name: "Copy of ${experimentInstance.name}", description: experimentInstance.description, experimentConfiguration: experimentInstance.experimentConfiguration, experimentStatus: ExperimentStatus.Paused)
      flash.message = "Experiment successfully duplicated. You may now edit the duplicated experiment before saving it."
      render(view: 'create', model: [experimentInstance: experimentCopy])
    } else {
      flash.error = "Experiment not found with id ${params.id}"
      redirect(action: list)
    }
  }


}
