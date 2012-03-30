package com.powertac.energy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Qualifier;

//import org.powertac.accounting.AccountingService;
import org.powertac.common.interfaces.CompetitionControl;
import org.powertac.common.interfaces.CompetitionSetup;
import org.powertac.distributionutility.DistributionUtilityService;
import org.powertac.server.CompetitionSetupService;
import org.powertac.server.ServerPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired // needed to discover sim mode
	private CompetitionControl competitionControlService;
	
	@Autowired
	private CompetitionSetup competitionSetupService;
	
	 @Autowired
	  private ServerPropertiesService serverProps;
	
	//@Autowired
	//private AccountingService accountingService;
	 
	 @Autowired
	 private DistributionUtilityService distributionUtilityService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/hometac", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException{
		logger.info("Welcome to PowerTac! the client locale is "+ locale.toString());
		
		if (competitionControlService != null && competitionSetupService != null){
			logger.info("SUCCESS: Controller service is wired ");
			String bootstrapFilename =
		              serverProps.getProperty("server.bootstrapDataFile",
		                                      "bd-noname.xml");
			FileWriter bootWriter = new FileWriter(new File(bootstrapFilename));
			competitionControlService.setAuthorizedBrokerList(new ArrayList<String>());
			competitionSetupService.preGame();
			competitionControlService.runOnce(true);
			
			//logger.info("The spot market price = "+distributionUtilityService.getSpotPrice());
			
			//competitionSetupService.saveBootstrapData(bootWriter);
		} else {
			logger.info("FAILURE: Controller service is not wired ");
		}
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
