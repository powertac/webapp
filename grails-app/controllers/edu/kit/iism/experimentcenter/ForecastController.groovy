package edu.kit.iism.experimentcenter

import grails.converters.XML

class ForecastController {

  def dataBinderService

  //REST closures

  def get = {
    def forecastInstance = Forecast.get(params.id)
    if (forecastInstance) {
      render forecastInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("Forecast with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      List forecastList = dataBinderService.bindAllXmlData(Forecast.class, request.XML, ['id', [targetTimeslot: Timeslot], [currentTimeslot: Timeslot], [tradingAgent: TradingAgent], [experiment: Experiment], 'value', 'forecastValue', 'stockType'])
      forecastList.each {forecastInstance ->
        if (forecastInstance.validate() && forecastInstance.save()) {
          log.debug("Forecast created: $forecastInstance")
        } else {
          throw new Exception("Failed to save Forecast '${forecastInstance}': ${forecastInstance.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${forecastList.size()} forecasts received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during forecastcreation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during forecast creation: ${e}")
        }
      }
    }
  }
}
