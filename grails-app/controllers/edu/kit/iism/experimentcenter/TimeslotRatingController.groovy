package edu.kit.iism.experimentcenter

import grails.converters.XML

class TimeslotRatingController {

  def dataBinderService

  //REST closures

  def get = {
    def timeslotRatingInstance = TimeslotRating.get(params.id)
    if (timeslotRatingInstance) {
      render timeslotRatingInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("TimeslotRating with id '${params.id}' not found.")
        }
      }
    }
  }

 def add = {
    try {
      List timeslotRatingList = dataBinderService.bindAllXmlData(TimeslotRating.class, request.XML, ['id', [targetTimeslot: Timeslot], [currentTimeslot: Timeslot], [tradingAgent: TradingAgent], [experiment: Experiment], 'shoutType', 'demandDesperatenessCoefficient', 'timeslotDesperatenessCoefficient', 'reservationPrice', 'lastTransactionPrice', 'initialTradeEntitlement', 'currentTradeEntitlement', 'inStockEntitlement', 'totalOrderCount', 'matchedOrderCount', 'successRate', 'profitMargin', 'desperateness', 'attractiveness', 'dateCreated'])
      timeslotRatingList.each {timeslotRating ->
        if (timeslotRating.validate() && timeslotRating.save()) {
          log.debug("TimeslotRating created: $timeslotRating")
        } else {
          throw new Exception("Failed to save TimeslotRating '${timeslotRating}': ${timeslotRating.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${timeslotRatingList.size()} timeslotRatings received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during timeslotRating creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during timeslotRating creation: ${e}")
        }
      }
    }
  }
}