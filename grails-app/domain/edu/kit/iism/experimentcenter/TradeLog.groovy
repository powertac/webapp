package edu.kit.iism.experimentcenter

class TradeLog extends AbstractLogEntry implements Serializable {

  String id
  Long transactionId
  Double price
  Double allocatedQuantityAsk
  Double allocatedQuantityBid
  Double executedVolume
  Double surplus
  String pricingStatus
  String allocationStatus
  String note
  Boolean writtenToExpCenter = false

  static mapping = {
    id generator: 'assigned' 
  }
  
  static constraints = {
    transactionId (nullable: true)
    price (nullable: true)
    allocatedQuantityAsk (nullable: true)
    allocatedQuantityBid (nullable: true)
    executedVolume (nullable: true)
    surplus (nullable: true)
    pricingStatus (nullable: true)
    allocationStatus (nullable: true)
    note (nullable: true)
    writtenToExpCenter (nullable: true)
  }
}
