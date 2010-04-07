package edu.ku.it.si.lovekusurvey.dao;

/**
 * Implements behaviors to enable
 * interaction with a data repository
 * that exists only in the JVM 
 * memory.
 * @author Bruce Phillips
 *
 */
public class SurveyDaoNoDB implements SurveyDao {
	
    /*
     * These values will be injected by the 
     * Spring container.
     */
	private int totalYesAnswers;
	private int totalNoAnswers;
	private int totalNotSureAnswers;

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalAnswers()
	 */
	public int getTotalAnswers() {
		
		return totalYesAnswers + totalNoAnswers + totalNotSureAnswers;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalDoNotLoveKUAnswers()
	 */
	public int getTotalDoNotLoveKUAnswers() {
		
		return totalNoAnswers;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalLoveKUAnswers()
	 */
	public int getTotalLoveKUAnswers() {
		
		return totalYesAnswers;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalNotSureLoveKUAnswers()
	 */
	public int getTotalNotSureLoveKUAnswers() {
		
		return totalNotSureAnswers;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#saveSurveyAnswer(int)
	 */
	public void saveSurveyAnswer(int answer) {
		
		switch(answer) {
		
		case 1 : totalNotSureAnswers++;
		         break;
		case 2 : totalNoAnswers++;
		         break;
		case 3 : totalYesAnswers++;
		         break;
		         
		}

	}


	public void setTotalYesAnswers(int totalYesAnswers) {
		this.totalYesAnswers = totalYesAnswers;
	}


	public void setTotalNoAnswers(int totalNoAnswers) {
		this.totalNoAnswers = totalNoAnswers;
	}


	public void setTotalNotSureAnswers(int totalNotSureAnswers) {
		this.totalNotSureAnswers = totalNotSureAnswers;
	}

}
