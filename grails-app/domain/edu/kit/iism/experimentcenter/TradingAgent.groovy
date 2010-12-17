package edu.kit.iism.experimentcenter

class TradingAgent implements Serializable {

  String id
  Experiment experiment
  String name
  String profileGenerator

  static belongsTo = [experiment: Experiment]

  static hasMany = [stocks: StockEntry, shouts: Shout, accountEntries: AccountEntry]

  static mapping = {
    id generator: 'assigned'
  }
  
  static constraints = {
    name(nullable: false)
    experiment(nullable: false)
    profileGenerator(nullable: false)
  }

  def String toString() {
    return "${name}"
  }


}
