package edu.kit.iism.experimentcenter

import grails.converters.XML

class StockEntryController {

  def dataBinderService

  //REST closures

  def get = {
    def stockEntryInstance = StockEntry.get(params.id)
    if (stockEntryInstance) {
      render stockEntryInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("StockEntry with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      def stockEntryList = dataBinderService.bindAllXmlData(StockEntry.class, request.XML, ['id', [experiment: Experiment], [tradingAgent: TradingAgent], [timeslot: Timeslot], 'stockType', 'powerTarget', 'powerAllocated', 'heatTarget', 'heatAllocated', 'description', 'lastUpdated'])
      stockEntryList.each {stockEntry ->
        if (stockEntry.save()) {
          log.debug("StockEntry created: $stockEntry")
        } else {
          throw new Exception("Failed to save StockEntry '${stockEntry}': ${stockEntry.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${stockEntryList.size()} stockEntries received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during StockEntry creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during StockEntry creation: ${e}")
        }
      }
    }
  }
}
