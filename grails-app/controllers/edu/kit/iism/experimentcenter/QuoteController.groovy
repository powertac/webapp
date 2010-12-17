package edu.kit.iism.experimentcenter

import grails.converters.XML

class QuoteController {

  def dataBinderService

  //REST closures

  def get = {
    def quoteInstance = Quote.get(params.id)
    if (quoteInstance) {
      render quoteInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("Quote with id '${params.id}' not found.")
        }
      }
    }
  }

 def add = {
    try {
      List quoteList = dataBinderService.bindAllXmlData(Quote.class, request.XML, ['id', [timeslot: Timeslot], [experiment: Experiment], 'quantityAsk', 'quantityBid', 'dateCreated', 'priceBid', 'priceAsk'])
      quoteList.each {quote ->
        if (quote.save()) {
          log.debug("Quote created: $quote")
        } else {
          throw new Exception("Failed to save Quote '${quote}': ${quote.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${quoteList.size()} quotes received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during quote creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during quote creation: ${e}")
        }
      }
    }
  }
}
