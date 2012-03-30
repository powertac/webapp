package com.powertac.energy.controller.timeslot;

import java.util.List;

import org.powertac.common.Timeslot;
import org.powertac.common.repo.TimeslotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class TimeSlotController extends MultiActionController {
	
	@Autowired
	private TimeslotRepo timeSlotRepo;
	
	@RequestMapping(value="timeSlots")
	public ModelAndView getEnabledTimeSlots(ModelMap model){
		
		List<Timeslot> timeSlots = timeSlotRepo.enabledTimeslots();
		
		return new ModelAndView("timeSlots","timeSlots",timeSlots);
		
	}

}
