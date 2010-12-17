package edu.kit.iism.experimentcenter

class AccountEntry implements Serializable {

  String id
  Experiment experiment
  TradingAgent tradingAgent
  Long transactionId
  String description
  Double value = 0.0
  Date lastUpdated = new Date()

  static belongsTo = [tradingAgent: TradingAgent, experiment: Experiment]

  static constraints = {
    experiment(nullable: false)
    tradingAgent(nullable: false)
    transactionId(nullable: true)
    description(nullable: true, blank: true, maxSize: 1024)
    value(nullable: false)
    lastUpdated(nullable: false)
  }

  static mapping = {
    id generator: 'assigned' 
  }
}
