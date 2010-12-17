package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.ExperimentStatus

class Experiment implements Serializable {

  Series series
  String name
  String description
  ExperimentStatus experimentStatus = ExperimentStatus.Pending
  String experimentConfiguration;
  Double minVersionExperimentRunner=0.0d
  Double maxVersionExperimentRunner=100.0d
  String targetMachine
  Date dateCreated = new Date()
  Date lastUpdated = new Date()

  static belongsTo = [series:Series]
  static hasMany = [tradeLogs: TradeLog, experimentErrors: ExperimentError]

  static mapping = {
    experimentConfiguration type: "text"
  }

  static constraints = {
    series(nullable: true)
    name (nullable: false, blank: false)
    description (nullable: true, maxSize: 1024)
    experimentStatus (nullable: false)
    minVersionExperimentRunner (nullable: false)
    maxVersionExperimentRunner (nullable: false)
    experimentConfiguration (nullable: false, blank: false)
    targetMachine(nullable: true)
  }

  public String toString() {
    return "${id} - ${this.name} (${this.experimentStatus})"
  }
}
