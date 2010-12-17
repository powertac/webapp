import edu.kit.iism.experimentcenter.CustomDateBinder
import groovy.util.slurpersupport.GPathResult
import org.apache.commons.lang.WordUtils
import org.springframework.beans.BeanWrapper
import org.springframework.beans.BeanWrapperImpl
import java.text.SimpleDateFormat
import org.springframework.beans.propertyeditors.CustomDateEditor

class DataBinderService {

  boolean transactional = false
  def grailsApplication
  private BeanWrapper wrapper = new BeanWrapperImpl()

  public List bindAllXmlData (Class targetClass, GPathResult source, List properties) {
    if (targetClass == null || source == null || properties == null) return null
    def resultList = []
    def  className = WordUtils.uncapitalize(targetClass.simpleName)
    source[className]?.each {
      def boundObj = bindXmlData(targetClass, it, properties)
      resultList.add(boundObj)
    }
    return resultList
  }

  public Object bindXmlData (Class targetClass, GPathResult source, List properties) {
    if (targetClass == null || source == null || properties == null) return null
    def targetObject = grailsApplication.classLoader.loadClass(targetClass.name).newInstance()
    if (targetObject) {
      return bindXmlData(targetObject, source, properties)
    } else {
      return null
    }
  }

  public Object bindXmlData (Object target, GPathResult source, List properties) {
    if (target == null || source == null || properties == null) return null
    wrapper.registerCustomEditor (Date.class, new CustomDateBinder())
    //wrapper.registerCustomEditor (Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z"), true))
    wrapper.setWrappedInstance(target)
    properties.each {property ->
      if (property instanceof Map) {//This indicates a domain class to bind e.g. experiment.id -> Experiment
        property.each {key,value ->
          def id = source[key]["@id"]?.toString()
          if (id != null) {
            def subdomainInstance = null
            try {
              subdomainInstance = value.get(id)
            } catch (Exception ex) {
              log.error "Failed to bind object $key with id ${id} to object ${target}", ex
            }
            if (subdomainInstance != null) wrapper.setPropertyValue(key, subdomainInstance)
          }
        }
      } else if (property.equals('id')) { //The id property is set as an attribute rather than text
        def id = source['@id']?.toString()
        if (id != null) wrapper.setPropertyValue(property, id)
      } else { //regular attributes
        def prop = source[property]?.toString()
        if (prop != null) wrapper.setPropertyValue(property, prop)
      }
    }
    return target
  }
}
