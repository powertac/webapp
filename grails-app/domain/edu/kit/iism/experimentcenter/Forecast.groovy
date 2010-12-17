package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.StockType

class Forecast implements Serializable {

  String id

  Timeslot targetTimeslot
  Timeslot currentTimeslot
  TradingAgent tradingAgent
  Experiment experiment
  StockType stockType
  Double value
  Double forecastValue

  static belongsTo = [tradingAgent: TradingAgent]
  
  static constraints = {
    targetTimeslot(nullable: false)
    currentTimeslot(nullable: false)
    tradingAgent(nullable: false)
    experiment(nullable: false)
    value(nullable: false)
    forecastValue(nullable: false)
  }

  static mapping = {
    id generator: 'assigned'
    targetTimeslot(index: 'forecast_tts_idx, forecast_exp_ta_tts_idx')
    currentTimeslot(index: 'forecast_cts_idx')
    tradingAgent(index: 'forecast_ta_idx, forecast_exp_ta_idx, forecast_exp_ta_tts_idx')
    experiment(index: 'forecast_exp_idx, forecast_exp_ta_idx, forecast_exp_ta_tts_idx')
  }
}
