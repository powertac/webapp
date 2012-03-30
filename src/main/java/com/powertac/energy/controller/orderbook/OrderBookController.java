package com.powertac.energy.controller.orderbook;

import java.util.List;

import org.powertac.common.Orderbook;
import org.powertac.common.Timeslot;
import org.powertac.common.repo.OrderbookRepo;
import org.powertac.common.repo.TimeslotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class OrderBookController extends MultiActionController {
	
	@Autowired
	private OrderbookRepo orderBookRepo;
	@Autowired
	private TimeslotRepo timeslotRepo;
	
	@RequestMapping(value="orderBooks",method=RequestMethod.GET)
	public ModelAndView getOrderBooks(ModelMap model){
		
		Timeslot ts = timeslotRepo.currentTimeslot();
		
		List<Orderbook> orderBookList = orderBookRepo.findAllByTimeslot(ts);
		
		return new ModelAndView("orderBooks","orderBooks",orderBookList);
		
	}

}
