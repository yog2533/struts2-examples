package edu.ku.it.si.lovekusurvey.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import edu.ku.it.si.lovekusurvey.service.SurveyService;

/**
 * Acts as controller for user 
 * actions related to the survey.
 * @author Bruce Phillips
 *
 */
public class SurveyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(this.getClass());
	
	/*
	 * A concrete object for this field will be 
	 * provided by the Spring container.
	 */
	private SurveyService surveyService;
	
	/*
	 * Value for this field is provided by the
	 * user's input on the Struts form
	 * on survey.jsp.
	 */
	private int answer;
	
	/*
	 *These fields will get a value
	 *by using the SurveyService
	 *class methods after processing
	 *the user's answer.
	 */
	private int yesPercentage;
	private int noPercentage;
	private int notSurePercentage;
	
	public String execute() {
		
		//save user's answer
		
		surveyService.saveAnswer(answer);
		
		//get percentage values
		
		yesPercentage = surveyService.getPercentageLoveKU() ;
		noPercentage = surveyService.getPercentageDoNotLoveKU();
		notSurePercentage = surveyService.getPercentageNotSureLoveKU();
		
		
		return SUCCESS;
		
	}
	
	public void validate(){
		
		log.debug("Answer value is " + answer);
		
		/* Check that answer form field was not empty 
		 * and is a legal value */
		if ( answer == 0 ){	

			log.error("No value for answer was received.");
			addFieldError( "answer", "You must select an answer!" );
			
		}
		
		if (answer != 1 && answer != 2 && answer != 3 ) {
			
			log.error("Illegal value for answer was received.  Answer value is " + answer);
			addFieldError("answer", "Answer not valid.  Select again.");
			
		}

}


	public int getAnswer() {
		return answer;
	}


	public void setAnswer(int answer) {
		this.answer = answer;
	}


	public int getYesPercentage() {
		return yesPercentage;
	}


	public void setYesPercentage(int yesPercentage) {
		this.yesPercentage = yesPercentage;
	}


	public int getNoPercentage() {
		return noPercentage;
	}


	public void setNoPercentage(int noPercentage) {
		this.noPercentage = noPercentage;
	}


	public int getNotSurePercentage() {
		return notSurePercentage;
	}


	public void setNotSurePercentage(int notSurePercentage) {
		this.notSurePercentage = notSurePercentage;
	}

	public SurveyService getSurveyService() {
		return surveyService;
	}

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}
	
}