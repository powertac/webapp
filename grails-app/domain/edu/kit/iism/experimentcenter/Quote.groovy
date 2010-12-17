package edu.kit.iism.experimentcenter

class Quote extends AbstractLogEntry implements Serializable{

  String id
  Double priceBid
  Double priceAsk

  static mapping = {
    id generator: 'assigned' 
  }
  
  static constraints = {
    priceBid(nullable: true)
    priceAsk(nullable: true)
  }
}
