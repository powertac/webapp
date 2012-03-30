package com.powertac.energy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.powertac.server.ServerPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class MainController extends MultiActionController{
	
	
	@RequestMapping(value="/layout",method=RequestMethod.GET)
	public String displayMainPage(){
		
		return "layout";
	}
	
	public ModelAndView save(HttpServletRequest requet, HttpServletResponse response){
		
		
		
		return null;
	}

}
