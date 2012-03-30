package com.powertac.energy.controller.tariff;

import java.util.List;

import org.powertac.common.Tariff;
import org.powertac.common.repo.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class TariffController extends MultiActionController {
	
	@Autowired
	private TariffRepo tariffRepo;
	
	@RequestMapping(value="/tariffs",method=RequestMethod.GET)
	public ModelAndView getTariff(ModelMap model){
		
		List<Tariff> tariffs = tariffRepo.findAllTariffs();
		
		return new ModelAndView("tariffs","tariffs",tariffs);
	}

}
