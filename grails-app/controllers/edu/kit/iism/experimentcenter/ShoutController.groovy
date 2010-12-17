package edu.kit.iism.experimentcenter

import grails.converters.XML

class ShoutController {

  def dataBinderService

  //REST closures

  def get = {
    def shoutInstance = Shout.get(params.id)
    if (shoutInstance) {
      render shoutInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("Shout with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      def shoutList = dataBinderService.bindAllXmlData(Shout.class, request.XML, ['id', [experiment: Experiment], [tradingAgent: TradingAgent], [timeslot: Timeslot], 'shoutType', 'shoutStatus', 'quantity', 'limitPrice', 'quantityAlloc', 'priceAlloc', 'transactionId', 'dateClosed', 'dateCreated', 'validUntil', 'comment'])
      shoutList.each {shout ->
        if(shout.save()) {
          log.debug("Shout created: $shout")
        } else {
          throw new Exception ("Failed to save shout '${shout}': ${shout.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${shoutList.size()} shouts received.")
        }
      }
    } catch (Exception e) {
      log.error ("An error occurred during shout creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during shout creation: ${e}")
        }
      }
    }
  }
}
