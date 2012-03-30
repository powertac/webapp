package com.powertac.energy.controller.broker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.powertac.common.Broker;
import org.powertac.common.repo.BrokerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@SessionAttributes({"brokers"})
public class BrokerController extends MultiActionController {

	@Autowired
	private BrokerRepo brokerRepo;
	
	@RequestMapping(value="/brokers",method=RequestMethod.GET)
	public ModelAndView getBrokers(ModelMap brokerMap){
		
		List<Broker> brokers = new ArrayList<Broker>();
	    brokers = brokerRepo.findRetailBrokers();
	    List<String> brokers1 = brokerRepo.findRetailBrokerNames();
	    List<Broker> brokers2 = brokerRepo.findRetailBrokers();
		
		return new ModelAndView("brokers","brokers",brokers);
	}
}
