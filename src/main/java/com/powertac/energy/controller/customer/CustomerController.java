package com.powertac.energy.controller.customer;

import java.util.ArrayList;
import java.util.Collection;

import org.powertac.common.CustomerInfo;
import org.powertac.common.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@SessionAttributes({"customers"})
public class CustomerController extends MultiActionController{
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@RequestMapping(value="/customer",method=RequestMethod.GET)
	public ModelAndView getCustomer(ModelMap model){
		
		Collection<CustomerInfo> customers = new ArrayList<CustomerInfo> ();
		
		customers = customerRepo.list();
		
		
		return new ModelAndView("customers","customers",customers);
		
	}

}
