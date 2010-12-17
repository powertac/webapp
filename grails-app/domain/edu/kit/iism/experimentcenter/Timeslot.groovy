package edu.kit.iism.experimentcenter

import java.text.SimpleDateFormat

class Timeslot implements Serializable {

  static final DATE_FORMAT = new SimpleDateFormat("dd.MM.yy-HH:mm:ss:SSS")
  static final SHORT_DATE_FORMAT = new SimpleDateFormat("HH:mm")
  static final TIMESLOTS_DEACTIVATED_AHEAD = 1 //number of future timeslots to deactivate as time goes by; 0 deativate timeslots only once currentTime = timeslot.startdatetime; 1= deactivate timeslot where currentTime = timeslot
  static final TIMESLOTS_AHEAD = 96 //slots = 1 day @ 15mins per time slot
  static final TIMESLOTS_TO_KEEP = 1344 //slots (= Two week history for 15-minute slots)
  static final TIMESLOT_LENGTH = 15 //minutes -- Attention changing constant requires the SimulationJob's cron expression to be changed consistently

  String id
  Long serialNumber
  Experiment experiment
  Date startDateTime
  Date endDateTime
  Boolean activated = true
  Double referencePrice
  Boolean current = false
  Date dateCreated = new Date()
  Date lastUpdated = new Date()
  Integer currentRound = 0
  Integer overallRounds = 0

  static hasMany = [stocks: StockEntry, shouts: Shout, experiment: Experiment]

  static constraints = {
    experiment(nullable: false)
    startDateTime(nullable: false)
    endDateTime(nullable: false)
    activated(nullable: false)
    referencePrice(nullable: true)
    current(nullable: false)
    dateCreated(nullable: false)
    lastUpdated(nullable: false)
    currentRound(nullable: false)
    overallRounds(nullable: false)
  }

  static mapping = {
    sort startDateTime: 'asc'
    id generator: 'assigned' 
  }

  def String toString() {
    "${DATE_FORMAT.format(startDateTime)} - ${DATE_FORMAT.format(endDateTime)}"
  }

  def String toShortString() {
    "${SHORT_DATE_FORMAT.format(startDateTime)} - ${SHORT_DATE_FORMAT.format(endDateTime)}"
  }
}
