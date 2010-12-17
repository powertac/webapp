package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.ShoutType

class TimeslotRating implements Serializable {

  String id

  Timeslot targetTimeslot
  Timeslot currentTimeslot
  TradingAgent tradingAgent
  Experiment experiment

  ShoutType shoutType
  Double demandDesperatenessCoefficient = 2d
  Double timeslotDesperatenessCoefficient = 2d
  Double reservationPrice
  Double lastTransactionPrice
  Double initialTradeEntitlement
  Double currentTradeEntitlement
  Double inStockEntitlement
  Long totalOrderCount
  Long matchedOrderCount

  Double successRate
  Double profitMargin
  Double desperateness
  Double attractiveness

  Date dateCreated = new Date()

  static belongsTo = [tradingAgent: TradingAgent]

  static constraints = {
    shoutType(nullable: true)
    reservationPrice(nullable: true)
    lastTransactionPrice(nullable: true)
    initialTradeEntitlement(nullable: true)
    currentTradeEntitlement(nullable: true)
    inStockEntitlement(nullable: true)
    totalOrderCount(nullable: true)
    matchedOrderCount(nullable: true)
    currentTimeslot(nullable: true)
    successRate(nullable: true)
    profitMargin(nullable: true)
    desperateness(nullable: true)
    attractiveness(nullable: true)
  }

  static mapping = {
    id generator: 'assigned'
    experiment (index: 'timeslot_rating_exp_idx, tsr_exp_ta_idx, tsr_exp_ta_tts_idx')
    tradingAgent (index: 'timeslot_rating_ta_idx, tsr_exp_ta_idx, tsr_exp_ta_tts_idx')
    targetTimeslot (index: 'timeslot_rating_tts_idx, tsr_exp_ta_tts_idx')
    currentTimeslot (index: 'timeslot_rating_cts_idx')
  }
}
