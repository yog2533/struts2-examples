package edu.ku.it.si.lovekusurvey.dao;

/**
 * Specifies the behaviors a 
 * SurveyDao class must define to 
 * enable interaction with a
 * data repository.
 * @author bruce phillips
 *
 */
public interface SurveyDao {
	
	/**
	 * Store the provided answer
	 * in the data repository.
	 * Valid values for answer are
	 * 1 - Not Sure
	 * 2 - No
	 * 3 - Yes
	 * @param answer (1 - Not Sure, 1 - No, or 3 - Yes)
	 */
	void saveSurveyAnswer(int answer);
	
	/**
	 * Get the total number of 
	 * survey answers that were
	 * yes love KU.
	 * @return total yes answers
	 */
	int getTotalLoveKUAnswers() ;
	
	/**
	 * Get the total number of
	 * survey answers that
	 * were no love KU.
	 * @return total no answers
	 */
	int getTotalDoNotLoveKUAnswers();
	
	/**
	 * Get the total number of
	 * survey answers that
	 * were not sure love ku.
	 * @return total not sure answers
	 */
	int getTotalNotSureLoveKUAnswers();
	
	/**
	 * Get total number of 
	 * answers.
	 * @return total number of answers
	 */
	int getTotalAnswers();

}
