package edu.kit.iism.experimentcenter

import edu.kit.iism.experimentcenter.enumerations.WorkerStatus

class WorkerClient implements Serializable {

  Long currentExperimentId
  String hostName
  String remoteHost
  String ipAddress
  String port
  String appVersion
  WorkerStatus workerStatus = WorkerStatus.Idle
  boolean online = false
  boolean enabled = true
  Date lastSeen
  String osName
  String osArch
  String osVersion
  String javaVendor
  String javaVersion
  String userName
  String userLanguage
  Date dateCreated = new Date()
  Date lastUpdated = new Date()

  static constraints = {
    currentExperimentId (nullable: true)
    hostName (nullable: false)
    remoteHost(nullable: false)
    ipAddress (nullable: true)
    appVersion (nullable: true)
    workerStatus (nullable: false)
    enabled (nullable: false)
    online (nullable: false)
    lastSeen (nullable: true)
    osName (nullable: true)
    osArch (nullable: true)
    osVersion (nullable: true)
    javaVendor (nullable: true)
    javaVersion (nullable: true)
    userName (nullable: true)
    userLanguage (nullable: true)
    dateCreated (nullable: false)
    lastUpdated (nullable: false)
  }

  public String toString() {
    return "${hostName} (Version: ${appVersion})"
  }
}
