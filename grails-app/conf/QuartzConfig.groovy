import grails.util.Environment

quartz {
  autoStartup = Environment.current != Environment.TEST
  jdbcStore = false
}

