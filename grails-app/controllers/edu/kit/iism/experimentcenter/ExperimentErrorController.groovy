package edu.kit.iism.experimentcenter

import org.springframework.dao.DataIntegrityViolationException
import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus

class ExperimentErrorController {

  def dataBinderService

  def scaffold = ExperimentError

  //REST closures

  def add = {
    try {
      ExperimentError experimentError = dataBinderService.bindXmlData(new ExperimentError(), request.XML, ['id', [experiment: Experiment], 'logLevel', 'errorMessage', 'errorStack'])

      if(experimentError.save()) {
        log.debug("ExperimentError created: $experimentError")
        experimentError.experiment.experimentStatus = ExperimentStatus.InvalidConfiguration
        experimentError.experiment.save()
      } else {
        throw new Exception ("Failed to save ExperimentError '${experimentError}': ${experimentError.errors}")
      }

      render(contentType: "text/xml") {
        info {
          message("Successfully received ExperimentError and saved it under id '${experimentError.id}'.")
        }
      }
    } catch (Exception e) {
      log.error ("An error occurred during ExperimentError creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during ExperimentError creation: ${e}")
        }
      }
    }
  }
}
