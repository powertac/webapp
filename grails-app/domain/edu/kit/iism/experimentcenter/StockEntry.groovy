package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.StockType

class StockEntry implements Serializable {
  String id
  Experiment experiment
  TradingAgent tradingAgent
  Timeslot timeslot
  StockType stockType
  Double powerTarget = 0.0d
  Double powerAllocated = 0.0d
  Double heatTarget = 0.0d
  Double heatAllocated = 0.0d
  String description
  Date lastUpdated = new Date()

  static belongsTo = [tradingAgent: TradingAgent, timeslot: Timeslot, experiment: Experiment]


  static constraints = {
    experiment(nullable: false)
    tradingAgent(nullable: false)
    timeslot(nullable: false)
    stockType (nullable: false)
    powerTarget(nullable: false)
    powerAllocated(nullable: false)
    heatTarget(nullable: false)
    heatAllocated(nullable: false)
    description(nullable: true, blank: true, maxSize: 1024)
  }

  static mapping = {
    id generator: 'assigned'
    experiment (index: 'joint_exp_ta_ts_st_desc_idx, joint_exp_ta_ts_st_idx, joint_exp_ta_ts_idx, stockentry_exp_idx')
    tradingAgent (index: 'joint_exp_ta_ts_st_desc_idx, joint_exp_ta_ts_st_idx, joint_exp_ta_ts_idx, stockentry_ta_idx')
    timeslot (index: 'joint_exp_ta_ts_st_desc_idx, joint_exp_ta_ts_st_idx, joint_exp_ta_ts_idx, stockentry_ts_idx')
    stockType (index: 'joint_exp_ta_ts_st_desc_idx, joint_exp_ta_ts_st_idx')
    description (index: 'joint_exp_ta_ts_st_desc_idx')
  }
}
