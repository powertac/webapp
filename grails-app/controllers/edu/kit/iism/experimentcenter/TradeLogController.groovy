package edu.kit.iism.experimentcenter

import grails.converters.XML
import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class TradeLogController {

  def dataBinderService

  //REST closures

  def get = {
    def tradeLogInstance = TradeLog.get(params.id)
    if (tradeLogInstance) {
      render tradeLogInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("TradeLog with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      List tradeLogList = dataBinderService.bindAllXmlData(TradeLog.class, request.XML, ['id', [timeslot: Timeslot], [experiment: Experiment], 'quantityAsk', 'quantityBid', 'dateCreated', 'transactionId', 'price', 'allocatedQuantityAsk', 'allocatedQuantityBid', 'executedVolume', 'surplus', 'pricingStatus', 'allocationStatus', 'note'])
      tradeLogList.each {tradeLog ->
        if (tradeLog.save()) {
          log.debug("TradeLog created: $tradeLog")
        } else {
          throw new Exception("Failed to save tradeLog '${tradeLog}': ${tradeLog.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${tradeLogList.size()} tradeLogs received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during tradeLog creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during tradeLog creation: ${e}")
        }
      }
    }
  }
}
