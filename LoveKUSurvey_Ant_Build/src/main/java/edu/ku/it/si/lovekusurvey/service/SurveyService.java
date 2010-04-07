package edu.ku.it.si.lovekusurvey.service;

/**
 * Defines behaviors that a 
 * SurveyService class must
 * implement to provide 
 * Services to a controller.
 * @author Bruce Phillips
 *
 */
public interface SurveyService {
	
	/**
	 * Store the answer provided 
	 * in the data repository.
	 * @param answer - legal values are
	 * 1 - Not Sure
	 * 2 - No
	 * 3 - Yes
	 * @throws IllegalArgumentException if provided
	 * parameter value is not 1, 2, or 3
	 */
	void saveAnswer(int answer) throws IllegalArgumentException ;
	
	/**
	 * Get percentage of people
	 * who answered yes to the 
	 * love KU question.
	 * @return percentage (as an integer) who love KU
	 */
	int getPercentageLoveKU();
	
	/**
	 * Get percentage of people
	 * who answered no to the 
	 * love KU question.
	 * @return percentage (as an integer) who don't love KU
	 */
	int getPercentageDoNotLoveKU();
	
	/**
	 * Get percentage of people
	 * who answered not sure to
	 * the love KU question.
	 * @return percentage (as an integer) who aren't sure they love KU
	 */
	int getPercentageNotSureLoveKU();
	
	/**
	 * Get total number of survey answers.
	 * @return total number of survey answers
	 */
	int getTotalAnswers();

}
