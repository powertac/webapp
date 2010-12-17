package edu.kit.iism.experimentcenter

import grails.converters.XML
import org.springframework.validation.BindException

class TimeslotController {

  def dataBinderService
  //REST closures

  def get = {
    def timeslotInstance = Timeslot.get(params.id)
    if (timeslotInstance) {
      render timeslotInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("Timeslot with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      def timeslotList = dataBinderService.bindAllXmlData(Timeslot.class, request.XML, ['id', [experiment: Experiment], 'serialNumber', 'startDateTime', 'endDateTime', 'activated', 'referencePrice', 'current', 'dateCreated', 'lastUpdated', 'currentRound', 'overallRounds'])
      timeslotList.each {timeslot ->
        if(timeslot.save()) {
          log.debug("Timeslot created: $timeslot")
        } else {
          throw new Exception ("Failed to save timeslot '${timeslot}': ${timeslot.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${timeslotList.size()} timeslots received.")
        }
      }
    } catch (Exception e) {
      log.error ("An error occurred during timeslot creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during timeslot creation: ${e}")
        }
      }
    }
  }
}
