package com.powertac.energy.view.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.powertac.server.ServerPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.powertac.energy.StartCompetition;
import com.powertac.energy.model.configuration.Configuration;

@Controller
@SessionAttributes({"configuration"})
public class ConfigurationController extends MultiActionController{
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);
	
	@Autowired
	private ServerPropertiesService config;
	
	@RequestMapping(value="/configuration",method=RequestMethod.GET)
	public ModelAndView getConfiguration(ModelMap model, @Valid Configuration configuration, BindingResult results){
		
		if (results.hasErrors()){
			return new ModelAndView ("configuration");
		}
		
		List<String> configurations = new ArrayList<String>(10);
		Configuration cfg =  new Configuration();
		
		
		String baseTime = config.getProperty("competition.baseTime");
		String minimumTimeslotCount = config.getProperty("competition.minimumTimeslotCount");
		String expectedTimeSlot = config.getProperty("competition.expectedTimeslotCount");
		String timeslotLength = config.getProperty("competition.timeslotLength");
		String simulationTimeslotSeconds = config.getProperty("competition.simulationTimeslotSeconds");
		String bootstrapTimeslotSeconds = config.getProperty("competition.bootstrapTimeslotSeconds");
		String timeslotsOpen = config.getProperty("competition.timeslotsOpen");
		String deactivateTimeslotsAhead = config.getProperty("competition.deactivateTimeslotsAhead");
		String bootstrapTimeslotCount = config.getProperty("competition.bootstrapTimeslotCount");
		String interest = config.getProperty("accounting.interest");
		String publicationFee = config.getProperty("tariffMarket.publicationFee");
		String publicationInterval = config.getProperty("tariffMarket.publicationInterval");
		String publicationOffset = config.getProperty("tariffMarket.publicationOffset");
		String sellerSurplus = config.getProperty("auctioneer.sellerSurplus");
		String defaultMargin = config.getProperty("auctioneer.defaultMargin");
		//String timeslotLength = config.getProperty("competition.timeslotLength");
		
		
		cfg.setBaseTime(baseTime);
		cfg.setMinimumTimeslotCount(minimumTimeslotCount);
		cfg.setExpectedTimeSlot(expectedTimeSlot);
		cfg.setTimeslotLength(timeslotLength);
		cfg.setBootstrapTimeslotSeconds(bootstrapTimeslotSeconds);
		cfg.setSimulationTimeslotSeconds(simulationTimeslotSeconds);
		cfg.setBootstrapTimeslotCount(bootstrapTimeslotCount);
		cfg.setDeactivateTimeslotsAhead(deactivateTimeslotsAhead);
		cfg.setTimeslotsOpen(timeslotsOpen);
		
		///cfg.setBootstrapTimeslotCount(bootstrapTimeslotCount);
		cfg.setInterest(interest);
		cfg.setPublicationFee(publicationFee);
		cfg.setDefaultMargin(defaultMargin);
		
		cfg.setSellerSurplus(sellerSurplus);
		cfg.setPublicationOffset(publicationOffset);
		cfg.setPublicationInterval(publicationInterval);
		
		return new ModelAndView ("configuration","configuration",cfg);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,HttpSession session,@ModelAttribute Configuration configuration,BindingResult result) throws Exception {
		Configuration configuration1 = (Configuration)request.getAttribute("configuration");
		Configuration configurations = (Configuration)request.getSession().getAttribute("configuration");
		Configuration configuration2 = (Configuration)session.getAttribute("configuration");
		Configuration configuration3 = (Configuration)result.getModel().get("configuration");
		String bateTime = configuration.getBaseTime();
	    
		logger.info("Saving configurations ....");
		
		
		String baseTime = configuration.getBaseTime();
		String minimumTimeslotCount = configuration.getMinimumTimeslotCount();
		String expectedTimeSlot = configuration.getExpectedTimeSlot();
		String timeslotLength = configuration.getTimeslotLength();
		String simulationTimeslotSeconds = configuration.getSimulationTimeslotSeconds();
		String bootstrapTimeslotSeconds = configuration.getBootstrapTimeslotSeconds();
		String timeslotsOpen = configuration.getTimeslotsOpen();
		String deactivateTimeslotsAhead = configuration.getDeactivateTimeslotsAhead();
		String bootstrapTimeslotCount = configuration.getBootstrapTimeslotCount();
		String interest = configuration.getInterest();
		String publicationFee = configuration.getPublicationFee();
		String publicationInterval = configuration.getPublicationInterval();
		String publicationOffset = configuration.getPublicationOffset();
		String sellerSurplus = configuration.getSellerSurplus();
		String defaultMargin = configuration.getDefaultMargin();
		
		
		config.setProperty("competition.baseTime", baseTime);
		config.setProperty("competition.minimumTimeslotCount", minimumTimeslotCount);
		config.setProperty("competition.expectedTimeslotCount", expectedTimeSlot);
		config.setProperty("competition.timeslotLength", timeslotLength);
		config.setProperty("competition.simulationTimeslotSeconds", simulationTimeslotSeconds);
		config.setProperty("competition.bootstrapTimeslotSeconds", bootstrapTimeslotSeconds);
		config.setProperty("competition.timeslotsOpen", timeslotsOpen);
		config.setProperty("competition.deactivateTimeslotsAhead", deactivateTimeslotsAhead);
		config.setProperty("competition.bootstrapTimeslotCount", bootstrapTimeslotCount);
		config.setProperty("accounting.interest", interest);
		config.setProperty("tariffMarket.publicationFee", publicationFee);
		config.setProperty("tariffMarket.publicationInterval", publicationInterval);
		config.setProperty("tariffMarket.publicationOffset", publicationOffset);
		config.setProperty("auctioneer.sellerSurplus", sellerSurplus);
		config.setProperty("auctioneer.defaultMargin", defaultMargin);
		
	
		return new ModelAndView ("configuration","configuration",configuration);
	}
	
	@RequestMapping(value="/cancel",method=RequestMethod.POST)
    public String cancel(){
		return "layout";
	}
}
