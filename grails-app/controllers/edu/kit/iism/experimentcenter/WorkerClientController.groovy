package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus
import org.springframework.dao.DataIntegrityViolationException

class WorkerClientController {

  def workerClientService
  static allowedMethods = [delete: 'POST', change: 'PUT', disabled: 'POST', enabled: 'POST']

  def index = {
    redirect(action: "list", params: params)
  }

  def list = {
    params.max = Math.min(params.max ? params.int('max') : 10, 100)
    workerClientService.run()
    [workerClientInstanceList: WorkerClient.list(params), workerClientInstanceTotal: WorkerClient.count()]
  }

  def show = {
    def workerClientInstance = WorkerClient.get(params.id)
    if (!workerClientInstance) {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'workerClient.label', default: 'WorkerClient'), params.id])}"
      redirect(action: "list")
    }
    else {
      [workerClientInstance: workerClientInstance]
    }
  }

  def delete = {
    def workerClientInstance = WorkerClient.get(params.id)
    if (workerClientInstance) {
      try {
        workerClientInstance.delete(flush: true)
        flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'workerClient.label', default: 'WorkerClient'), params.id])}"
        redirect(action: "list")
      }
      catch (org.springframework.dao.DataIntegrityViolationException e) {
        flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'workerClient.label', default: 'WorkerClient'), params.id])}"
        redirect(action: "show", id: params.id)
      }
    }
    else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'workerClient.label', default: 'WorkerClient'), params.id])}"
      redirect(action: "list")
    }
  }


  def disable = {
    def workerClientInstance = WorkerClient.get(params.id)
    if (workerClientInstance) {
      workerClientInstance.enabled = false
      workerClientInstance.save()
      flash.message = "Worker Client ${workerClientInstance} disabled"
    } else {
      flash.error = "Worker Client not found with id ${params.id}"
    }
    redirect(action: list)
  }

  def enable = {
    def workerClientInstance = WorkerClient.get(params.id)
    if (workerClientInstance) {
      workerClientInstance.enabled = true
      workerClientInstance.save()
      flash.message = "Worker Client ${workerClientInstance} enabled"
    } else {
      flash.error = "Worker Client not found with id ${params.id}"
    }
    redirect(action: list)
  }

  // Rest Methods (see conf/UrlMappings)
  def change = {
    WorkerClient workerClient = null
    try {
      workerClient = WorkerClient.findByHostName(params?.workerClient?.hostName)
      if (!workerClient) workerClient = new WorkerClient()
      workerClient.properties['currentExperimentId', 'hostName', 'appVersion', 'osName', 'osArch', 'osVersion', 'javaVendor', 'javaVersion', 'userName', 'userLanguage', 'workerStatus'] = params['workerClient']
      workerClient.ipAddress = request.getRemoteAddr()
      workerClient.port = request.getRemotePort()?.toString()
      workerClient.remoteHost = request.getRemoteHost()
      workerClient.lastSeen = new Date()
      workerClient.online = true
      if (workerClient.save()) {
        if (workerClient.currentExperimentId) {
          Experiment experiment = Experiment.get(currentExperimentId)
          if (experiment?.experimentStatus == ExperimentStatus.Cancelled) {
            render(contentType: "text/xml") {
              info {
                message("Cancel Experiment")
              }
            }
          } else {
            render(contentType: "text/xml") {
              info {
                message("Cancel Experiment")
              }
            }  
          }
        } else {
          render(contentType: "text/xml") {
            info {
              message("WorkerClient Status updated")
            }
          }
        }
      } else {
        throw new DataIntegrityViolationException("A data integrity violation occurred:  ${workerClient.errors.allErrors.toListString()}")
      }
    } catch (Exception e) {
      workerClient?.discard()
      render(contentType: "text/xml", status: 500) {
        error {
          e.getMessage()
        }
      }
    }
  }
}
