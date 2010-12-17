package edu.kit.iism.experimentcenter

class ExperimentError implements Serializable {

  Experiment experiment
  String logLevel = "INFO"
  String errorMessage
  String errorStack
  Date dateCreated = new Date()

  static belongsTo = [experiment: Experiment]

  static mapping = {
    errorStack  type: "text"
  }

  static constraints = {
    experiment (nullable: false)
    logLevel (nullable: false, maxSize: 128)
    errorMessage (nullable: false, blank: true, maxSize: 1024)
    errorStack (nullable: true, blank: true)
  }

  public String toString() {
    return "${logLevel}: ${errorMessage}"
  }
}
