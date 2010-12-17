package edu.kit.iism.experimentcenter

import grails.converters.XML

class TradingAgentController {

  def dataBinderService

//REST closures

  def get = {
    def tradingAgentInstance = TradingAgent.get(params.id)
    if (tradingAgentInstance) {
      render tradingAgentInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("TradingAgent with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      List tradingAgentList = dataBinderService.bindAllXmlData(TradingAgent.class, request.XML, ['id', [experiment: Experiment], 'name', 'profileGenerator'])
      tradingAgentList.each {tradingAgent ->
        if (tradingAgent.save()) {
          log.debug("TradingAgent created: $tradingAgent")
        } else {
          throw new Exception("Failed to save TradingAgent '${tradingAgent}': ${tradingAgent.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${tradingAgentList.size()} tradingAgents received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during tradingAgent creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during tradingAgent creation: ${e}")
        }
      }
    }
  }
}
