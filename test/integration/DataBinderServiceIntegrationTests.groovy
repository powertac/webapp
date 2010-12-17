import edu.kit.iism.experimentcenter.Experiment
import edu.kit.iism.experimentcenter.Timeslot
import edu.kit.iism.experimentcenter.TradeLog

class DataBinderServiceIntegrationTests extends GroovyTestCase {

  def dataBinderService
  def exp1
  def timeslot1
  def xmlTimeslot
  def xmlTimeslotRestString = '''
<list>
  <timeslot id="ff80818122e628010122e6286f5a0001">
    <activated>false</activated>
    <current>false</current>
    <currentRound>0</currentRound>
    <dateCreated>2009-08-04 18:05:25.465 MESZ</dateCreated>
    <endDateTime>2006-06-05 14:14:59.0 MESZ</endDateTime>
    <experiment id="1" />
    <lastUpdated>2009-08-04 18:05:25.465 MESZ</lastUpdated>
    <shouts />
    <startDateTime>2006-06-05 14:00:00.0 MESZ</startDateTime>
    <stocks />
  </timeslot>
  <timeslot id="ff80818122e628010122e62870ad0002"><activated>false</activated><current>false</current><currentRound>1</currentRound><dateCreated>2009-08-04 18:05:25.801 MESZ</dateCreated><endDateTime>2006-06-05 14:29:59.0 MESZ</endDateTime><experiment id="1" /><lastUpdated>2009-08-04 18:05:27.613 MESZ</lastUpdated><shouts /><startDateTime>2006-06-05 14:15:00.0 MESZ</startDateTime><stocks /></timeslot><timeslot id="ff80818122e628010122e62870b40003"><activated>true</activated><current>true</current><currentRound>2</currentRound><dateCreated>2009-08-04 18:05:25.812 MESZ</dateCreated><endDateTime>2006-06-05 14:44:59.0 MESZ</endDateTime><experiment id="1" /><lastUpdated>2009-08-04 18:05:28.962 MESZ</lastUpdated><shouts /><startDateTime>2006-06-05 14:30:00.0 MESZ</startDateTime><stocks /></timeslot><timeslot id="ff80818122e628010122e62877530008"><activated>true</activated><current>false</current><currentRound>1</currentRound><dateCreated>2009-08-04 18:05:27.506 MESZ</dateCreated><endDateTime>2006-06-05 14:59:59.0 MESZ</endDateTime><experiment id="1" /><lastUpdated>2009-08-04 18:05:28.965 MESZ</lastUpdated><shouts /><startDateTime>2006-06-05 14:45:00.0 MESZ</startDateTime><stocks /></timeslot></list>
'''
  def xmlTradeLog
  def xmlTradelogRestString = '''
<list>
  <tradeLog id="ff80818122e6616f0122e66423170048">
    <allocatedQuantityAsk />
    <allocatedQuantityBid />
    <allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus>
    <dateCreated>2009-08-04 19:10:38.102 MESZ</dateCreated>
    <executedVolume />
    <experiment id="1" />
    <note>Geld</note>
    <price>9.81</price>
    <pricingStatus>Success</pricingStatus>
    <quantityAsk>0.0</quantityAsk>
    <quantityBid>232.9</quantityBid>
    <surplus>232.9</surplus>
    <timeslot id="ff80818122e6616f0122e664202b002c" />
    <transactionId>1249405838095</transactionId>
    <writtenToExpCenter>false</writtenToExpCenter>
  </tradeLog>
<tradeLog id="ff80818122e6616f0122e664231e0049"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.109 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>14.75</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>245.5</quantityBid><surplus>245.5</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838095</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog><tradeLog id="ff80818122e6616f0122e6642323004a"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.115 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>13.4</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>245.5</quantityBid><surplus>245.5</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838095</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog><tradeLog id="ff80818122e6616f0122e6642328004b"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.120 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>12.47</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>257.4</quantityBid><surplus>257.4</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838095</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog><tradeLog id="ff80818122e6616f0122e664265c0069"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.940 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>11.12</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>245.5</quantityBid><surplus>245.5</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838937</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog><tradeLog id="ff80818122e6616f0122e6642661006a"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.945 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>10.71</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>245.5</quantityBid><surplus>245.5</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838937</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog><tradeLog id="ff80818122e6616f0122e6642666006b"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.950 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>11.61</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>257.4</quantityBid><surplus>257.4</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838937</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog><tradeLog id="ff80818122e6616f0122e6642671006c"><allocatedQuantityAsk /><allocatedQuantityBid /><allocationStatus>Stats did not contain information on executable volume and / or price.</allocationStatus><dateCreated>2009-08-04 19:10:38.960 MESZ</dateCreated><executedVolume /><experiment id="1" /><note>Geld</note><price>12.25</price><pricingStatus>Success</pricingStatus><quantityAsk>0.0</quantityAsk><quantityBid>263.1</quantityBid><surplus>263.1</surplus><timeslot id="ff80818122e6616f0122e664202b002c" /><transactionId>1249405838937</transactionId><writtenToExpCenter>false</writtenToExpCenter></tradeLog></list>
'''

  void setUp() {
    exp1 = new Experiment(name: "testname", description: "testdesc", experimentConfiguration: "testconfig").save()
    assert(exp1)
    timeslot1 = new Timeslot(startDateTime: new Date(), endDateTime: new Date())
    timeslot1.id = 'test'
    timeslot1.save()
    assert(timeslot1)
    xmlTimeslotRestString = xmlTimeslotRestString.replace("<experiment id=\"1\" />", "<experiment id=\"${exp1.id}\" />")
    xmlTimeslot = new XmlSlurper().parseText(xmlTimeslotRestString)
    xmlTradelogRestString = xmlTradelogRestString.replace("<experiment id=\"1\" />", "<experiment id=\"${exp1.id}\" />")
    xmlTradelogRestString = xmlTradelogRestString.replace("<timeslot id=\"ff80818122e6616f0122e664202b002c\" />", "<timeslot id=\"${timeslot1.id}\" />")
    xmlTradeLog = new XmlSlurper().parseText(xmlTradelogRestString)
  }

  void testBindObjectPropertiesListIsNull() {
    xmlTimeslot.timeslot?.each {ts ->
      def timeslot = dataBinderService.bindXmlData(new Timeslot(), ts, null)
      assertNull(timeslot)
    }
  }

  void testBindObjectTargetIsNull() {
    xmlTimeslot.timeslot?.each {ts ->
      def timeslot = dataBinderService.bindXmlData(null, ts, ['id', [experiment: Experiment], 'startDateTime', 'endDateTime', 'activated', 'current', 'dateCreated', 'lastUpdated', 'currentRound'])
      assertNull(timeslot)
    }
  }

  void testBindObjectSourceIsNull() {
    xmlTimeslot.timeslot?.each {ts ->
      def timeslot = dataBinderService.bindXmlData(new Timeslot(), null, ['id', [experiment: Experiment], 'startDateTime', 'endDateTime', 'activated', 'current', 'dateCreated', 'lastUpdated', 'currentRound'])
      assertNull(timeslot)
    }
  }

  void testBindTimeslotObject() {
    xmlTimeslot.timeslot?.each {ts ->
      def timeslot = dataBinderService.bindXmlData(new Timeslot(), ts, ['id', [experiment: Experiment], 'startDateTime', 'endDateTime', 'activated', 'current', 'dateCreated', 'lastUpdated', 'currentRound'])
      assertTrue(timeslot.validate())
      assertEquals(exp1.id, timeslot.experiment.id)
    }
  }

  void testBindTimeslotClass() {
    xmlTimeslot.timeslot?.each {ts ->
      def timeslot = dataBinderService.bindXmlData(Timeslot.class, ts, ['id', [experiment: Experiment], 'startDateTime', 'endDateTime', 'activated', 'current', 'dateCreated', 'lastUpdated', 'currentRound'])
      assertTrue(timeslot.validate())
      assertEquals(exp1.id, timeslot.experiment.id)
    }
  }


  void testBindAllTimeslots() {
    List timeslots = dataBinderService.bindAllXmlData(Timeslot.class, xmlTimeslot, ['id', [experiment: Experiment], 'startDateTime', 'endDateTime', 'activated', 'current', 'dateCreated', 'lastUpdated', 'currentRound'])
    assertEquals(4, timeslots.size())
    timeslots.each {
      assertTrue(it.validate())
      assertEquals(exp1.id, it.experiment.id)
    }
  }

  void testBindTradeLogObject() {
    xmlTimeslot.tradeLog?.each {ts ->
      def tradeLog = dataBinderService.bindXmlData(new TradeLog(), ts, ['id', [timeslot: Timeslot], [experiment: Experiment], 'quantityAsk', 'quantityBid', 'dateCreated', 'transactionId', 'price', 'allocatedQuantityAsk', 'allocatedQuantityBid', 'executedVolume', 'surplus', 'pricingStatus', 'allocationStatus', 'note'])
      assertTrue(tradeLog.validate())
      assertEquals(exp1.id, tradeLog.experiment.id)
      assertEquals(timeslot1.id, tradeLog.timeslot.id)
      assertEquals('Stats did not contain information on executable volume and / or price.', tradeLog.allocationStatus)
      assertEquals('Success', tradeLog.pricingStatus)
      assertEquals('Geld', tradeLog.note)
    }
  }

  void testBindTradeLogClass() {
    xmlTimeslot.tradeLog?.each {ts ->
      def tradeLog = dataBinderService.bindXmlData(TradeLog.class, ts, ['id', [timeslot: Timeslot], [experiment: Experiment], 'quantityAsk', 'quantityBid', 'dateCreated', 'transactionId', 'price', 'allocatedQuantityAsk', 'allocatedQuantityBid', 'executedVolume', 'surplus', 'pricingStatus', 'allocationStatus', 'note'])
      assertTrue(tradeLog.validate())
      assertEquals(exp1.id, tradeLog.experiment.id)
      assertEquals(timeslot1.id, tradeLog.timeslot.id)
      assertEquals('Stats did not contain information on executable volume and / or price.', tradeLog.allocationStatus)
      assertEquals('Success', tradeLog.pricingStatus)
      assertEquals('Geld', tradeLog.note)
    }
  }

  void testBindAllTradelogs() {
    List tradeLogs = dataBinderService.bindAllXmlData(TradeLog.class, xmlTradeLog, ['id', [timeslot: Timeslot], [experiment: Experiment], 'executedVolume', 'quantityAsk', 'quantityBid', 'dateCreated', 'transactionId', 'price', 'allocatedQuantityAsk', 'allocatedQuantityBid', 'executedVolume', 'surplus', 'pricingStatus', 'allocationStatus', 'note'])
    assertEquals(8, tradeLogs.size())
    tradeLogs.each {tr ->
      assertNotNull(tr.validate())
      assertEquals(exp1.id, tr.experiment.id)
      assertEquals(timeslot1.id, tr.timeslot.id)
      assertEquals('Stats did not contain information on executable volume and / or price.', tr.allocationStatus)
      assertEquals('Success', tr.pricingStatus)
      assertEquals('Geld', tr.note)
    }
  }

}
