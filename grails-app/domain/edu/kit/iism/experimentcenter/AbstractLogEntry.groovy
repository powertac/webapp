package edu.kit.iism.experimentcenter

class AbstractLogEntry implements Serializable {

  String id
  Timeslot timeslot
  Experiment experiment
  double quantityAsk
  double quantityBid
  Date dateCreated = new Date()

  static belongsTo = [timeslot: Timeslot, experiment: Experiment]

  static mapping = {
    id generator: 'assigned'
  }

  static constraints = {
    experiment(nullable: false)
    timeslot(nullable: false)
    quantityAsk(nullable: true)
    quantityBid(nullable: true)
    dateCreated(nullable: false)
  }
}
