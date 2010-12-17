package edu.kit.iism.experimentcenter

import grails.converters.XML

class AccountEntryController {

  def dataBinderService

//REST closures

  def get = {
    def accountEntryInstance = AccountEntry.get(params.id)
    if (accountEntryInstance) {
      render accountEntryInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("AccountEntry with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      def accountEntryList = dataBinderService.bindAllXmlData(AccountEntry.class, request.XML, ['id', [experiment: Experiment], [tradingAgent: TradingAgent], 'transactionId', 'description', 'value', 'lastUpdated'])
      accountEntryList.each {accountEntry ->
        if (accountEntry.save()) {
          log.debug("AccountEntry created: $accountEntry")
        } else {
          throw new Exception("Failed to save AccountEntry '${accountEntry}': ${accountEntry.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${accountEntryList.size()} accountEntries received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during AccountEntry creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during AccountEntry creation: ${e}")
        }
      }
    }
  }
}
