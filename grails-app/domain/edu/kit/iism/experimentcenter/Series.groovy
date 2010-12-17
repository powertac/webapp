package edu.kit.iism.experimentcenter

class Series {

  String name

  static hasMany = [experiments: Experiment]

  static constraints = {
    name(nullable: false, unique: true)
  }

  public String toString() {
    return name
  }
}
