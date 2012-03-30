package com.powertac.energy.controller.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
//@RequestMapping("/master")
public class MasterController extends MultiActionController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	@RequestMapping(value="/brokers1",method=RequestMethod.GET)
	public String brokers(){
		logger.info("Redirecting to the brokers page ..........................");
		return "brokers";
	}

}
