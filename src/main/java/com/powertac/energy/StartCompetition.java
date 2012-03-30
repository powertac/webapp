package com.powertac.energy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.powertac.common.interfaces.CompetitionControl;
import org.powertac.common.interfaces.CompetitionSetup;
import org.powertac.distributionutility.DistributionUtilityService;
import org.powertac.server.ServerPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/start")
public class StartCompetition {
	
	private static final Logger logger = LoggerFactory.getLogger(StartCompetition.class);
	
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
	
	@RequestMapping(value="/startgame",method=RequestMethod.GET)
	public String startCompetition(@ModelAttribute("hiddenData") HiddenData hiddenData,Model model) throws IOException{
		
		String start =hiddenData.getStart();
		
		if ("start".equals(start)){
			logger.info("The game is starting ...... "+start);
			
			if (competitionControlService != null && competitionSetupService != null){
				logger.info("SUCCESS: Controller service is wired ");
				/* serverProps.setUserConfig(new URL("file:config/test.properties"));
				String bootstrapFilename =
			              serverProps.getProperty("server.bootstrapDataFile",
			                                      "bd-noname.xml");*/
				
				competitionControlService.setAuthorizedBrokerList(new ArrayList<String>());
				 competitionSetupService.preGame();
				 new Thread(new Runnable() {
					  public void run() {
						  competitionControlService.runOnce(true);
					  }
					}).start();
				 
				
				
				
				//competitionSetupService.saveBootstrapData(bootWriter);
			} else {
				logger.info("FAILURE: Controller service is not wired ");
			}
		} else if ("sp".equals(start)){
			double spotPrice = distributionUtilityService.getSpotPrice();
			logger.info("The spot market price = "+distributionUtilityService.getSpotPrice());
		} else {
			logger.info("The game was not started ...... "+start);
		}
		
		logger.info("After the game was started ...... "+start);
		
		return "startgame";
		
	}
	
	 
}
