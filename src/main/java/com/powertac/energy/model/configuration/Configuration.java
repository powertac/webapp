package com.powertac.energy.model.configuration;

import org.hibernate.validator.constraints.NotEmpty;



public class Configuration {

	@NotEmpty
	private String baseTime="1"; 
	private String minimumTimeslotCount;
	private String expectedTimeSlot;
	private String timeslotLength;
	private String simulationTimeslotSeconds;

	private String bootstrapTimeslotSeconds;


	private String	timeslotsOpen;


	private String deactivateTimeslotsAhead;


	private String	bootstrapTimeslotCount;


	private String	interest;


	private String publicationFee;


	private String publicationInterval;


	private String publicationOffset;


	private String sellerSurplus;


	private String defaultMargin;

	public String getBaseTime() {
		return baseTime;
	}
	public void setBaseTime(String baseTime) {
		this.baseTime = baseTime;
	}
	public String getMinimumTimeslotCount() {
		return minimumTimeslotCount;
	}
	public void setMinimumTimeslotCount(String minimumTimeslotCount) {
		this.minimumTimeslotCount = minimumTimeslotCount;
	}
	public String getExpectedTimeSlot() {
		return expectedTimeSlot;
	}
	public void setExpectedTimeSlot(String expectedTimeSlot) {
		this.expectedTimeSlot = expectedTimeSlot;
	}
	public String getTimeslotLength() {
		return timeslotLength;
	}
	public void setTimeslotLength(String timeslotLength) {
		this.timeslotLength = timeslotLength;
	}
	public String getSimulationTimeslotSeconds() {
		return simulationTimeslotSeconds;
	}
	public void setSimulationTimeslotSeconds(String simulationTimeslotSeconds) {
		this.simulationTimeslotSeconds = simulationTimeslotSeconds;
	}
	public String getBootstrapTimeslotSeconds() {
		return bootstrapTimeslotSeconds;
	}
	public void setBootstrapTimeslotSeconds(String bootstrapTimeslotSeconds) {
		this.bootstrapTimeslotSeconds = bootstrapTimeslotSeconds;
	}
	public String getTimeslotsOpen() {
		return timeslotsOpen;
	}
	public void setTimeslotsOpen(String timeslotsOpen) {
		this.timeslotsOpen = timeslotsOpen;
	}
	public String getDeactivateTimeslotsAhead() {
		return deactivateTimeslotsAhead;
	}
	public void setDeactivateTimeslotsAhead(String deactivateTimeslotsAhead) {
		this.deactivateTimeslotsAhead = deactivateTimeslotsAhead;
	}
	public String getBootstrapTimeslotCount() {
		return bootstrapTimeslotCount;
	}
	public void setBootstrapTimeslotCount(String bootstrapTimeslotCount) {
		this.bootstrapTimeslotCount = bootstrapTimeslotCount;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPublicationFee() {
		return publicationFee;
	}
	public void setPublicationFee(String publicationFee) {
		this.publicationFee = publicationFee;
	}
	public String getPublicationInterval() {
		return publicationInterval;
	}
	public void setPublicationInterval(String publicationInterval) {
		this.publicationInterval = publicationInterval;
	}
	public String getPublicationOffset() {
		return publicationOffset;
	}
	public void setPublicationOffset(String publicationOffset) {
		this.publicationOffset = publicationOffset;
	}
	public String getSellerSurplus() {
		return sellerSurplus;
	}
	public void setSellerSurplus(String sellerSurplus) {
		this.sellerSurplus = sellerSurplus;
	}
	public String getDefaultMargin() {
		return defaultMargin;
	}
	public void setDefaultMargin(String defaultMargin) {
		this.defaultMargin = defaultMargin;
	}
}
