package edu.kit.iism.experimentcenter

import grails.converters.XML

class BlockShoutController {

  def dataBinderService
 

  //REST closures

  def get = {
    def blockShoutInstance = BlockShout.get(params.id)
    if (blockShoutInstance) {
      render blockShoutInstance as XML
    } else {
      render(contentType: "text/xml") {
        error {
          message("BlockShout with id '${params.id}' not found.")
        }
      }
    }
  }

  def add = {
    try {
      //Todo: implement data binding for referenced child shouts
      def shoutList = dataBinderService.bindAllXmlData(BlockShout.class, request.XML, ['id', [experiment: Experiment], [tradingAgent: TradingAgent], 'shoutType', 'shoutStatus', 'tradingDay', 'quantityPerTimeslot', 'limitPrice', 'averageAllocationPrice', 'transactionId', 'dateClosed', 'dateCreated', 'validUntil', 'comment'])
      shoutList.each {shout ->
        if (shout.save()) {
          log.debug("BlockShout created: $shout")
        } else {
          throw new Exception("Failed to save BlockShout '${shout}': ${shout.errors}")
        }
      }
      render(contentType: "text/xml") {
        info {
          message("${shoutList.size()} BlockShouts received.")
        }
      }
    } catch (Exception e) {
      log.error("An error occurred during BlockShout creation.", e)
      render(contentType: "text/xml") {
        error {
          message("An error occurred during BlockShout creation: ${e}")
        }
      }
    }
  }
}
