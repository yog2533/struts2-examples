package edu.ku.it.si.lovekusurvey.service;

import org.apache.log4j.Logger;

import edu.ku.it.si.lovekusurvey.dao.SurveyDao;

/**
 * Implements behaviors required of a
 * SurveyService class to provide
 * services related to survey answers
 * to a controller.
 * @author Bruce Phillips
 *
 */
public class SurveyServiceImpl implements SurveyService {
	
	/*
	 * Concrete value for this reference will be injected
	 * by the Spring container.
	 */
	private SurveyDao surveyDao;
	
	private final Logger log = Logger.getLogger(this.getClass());

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.service.SurveyService#getPercentageDoNotLoveKU()
	 */
	public int getPercentageDoNotLoveKU() {
		
		//to avoid integer division problem store as type double
		double noAnswers = surveyDao.getTotalDoNotLoveKUAnswers() ;
		double totalAnswers = surveyDao.getTotalAnswers() ;
		
		double noPercentage = (noAnswers / totalAnswers) * 100 ;
		
		//convert to integer and return
		return (int) noPercentage;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.service.SurveyService#getPercentageLoveKU()
	 */
	public int getPercentageLoveKU() {
		
		//to avoid integer division problem store as type double
		double yesAnswers = surveyDao.getTotalLoveKUAnswers() ;
		double totalAnswers = surveyDao.getTotalAnswers() ;
		
		double yesPercentage = (yesAnswers / totalAnswers) * 100 ;
		
		//convert to integer and return
		return (int) yesPercentage;

	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.service.SurveyService#getPercentageNotSureLoveKU()
	 */
	public int getPercentageNotSureLoveKU() {
		
		//to avoid integer division problem store as type double
		double notSureAnswers = surveyDao.getTotalNotSureLoveKUAnswers();
		double totalAnswers = surveyDao.getTotalAnswers() ;
		
		double notSurePercentage = (notSureAnswers / totalAnswers) * 100 ;
		
		//convert to integer and return
		return (int) notSurePercentage;

		
	}

    /*
     * (non-Javadoc)
     * @see edu.ku.it.si.lovekusurvey.service.SurveyService#saveAnswer(int)
     */
	public void saveAnswer(int answer) throws IllegalArgumentException {
		
		//check if parameter value is valid
		if (answer != 1 && answer != 2 && answer != 3) {
			
			log.error("An illegal value for answer parameter was provided.  Value provided for answer was " + answer);
			
			throw new IllegalArgumentException("Answer value must be 1 (for not sure), 2 (for no), or 3 (for yes). " 
			  + answer + " is not a valid value.");
			
		}
		
		surveyDao.saveSurveyAnswer(answer);

	}

	public void setSurveyDao(SurveyDao surveyDao) {
		this.surveyDao = surveyDao;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.service.SurveyService#getTotalAnswers()
	 */
	public int getTotalAnswers() {

		return surveyDao.getTotalAnswers() ;
	}



}
