import edu.kit.iism.experimentcenter.Experiment
import grails.converters.XML
import java.sql.Timestamp

class BootStrap {

  def authenticateService

  def init = {servletContext ->

    //Define custom xml date marshaller
    XML.registerObjectMarshaller(Date) {date -> // register a custom marshaller for the class java.util.Date
      return date.getTime()
    }

    XML.registerObjectMarshaller (Timestamp) {Timestamp timestamp ->
      timestamp.getTime()
    }

    //Define default users
    def md5pass = authenticateService.passwordEncoder('testit')

    //Create Default Authorities
    def roleUser= Role.findByAuthority ('ROLE_USER')
    if (!roleUser) roleUser = new Role(authority: 'ROLE_USER', description: 'Regular Users').save()

    def roleAdmin= Role.findByAuthority ('ROLE_ADMIN')
    if (!roleAdmin) roleAdmin = new Role(authority: 'ROLE_ADMIN', description: 'Admin Users').save()

    def userNormal = User.findByUsername('user')
    if (!userNormal) {
      userNormal = new User(username: 'user', userRealName: 'testuser', passwd: md5pass, enabled: true, email: 'email1@mailinator.com', description: 'Demo User')
      userNormal.save()
      roleUser.addToPeople(userNormal)
    }
    def userAdmin = User.findByUsername('admin')
    if (!userAdmin) {
      userAdmin = new User(username: 'admin', userRealName: 'admin user', passwd: md5pass, enabled: true, email: 'email2@mailinator.com', description: 'Default admin')
      userAdmin.save()
      roleUser.addToPeople(userAdmin)
      roleAdmin.addToPeople(userAdmin)
    }

  }
  def destroy = {
  }
} 
