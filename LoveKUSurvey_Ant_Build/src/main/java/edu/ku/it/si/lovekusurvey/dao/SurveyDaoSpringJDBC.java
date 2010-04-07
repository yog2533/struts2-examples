package edu.ku.it.si.lovekusurvey.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * Implements behaviors for interaction with a database data repository and uses
 * Spring JDBC to query the database.
 * @author brucephillips
 *
 */
public class SurveyDaoSpringJDBC extends SimpleJdbcDaoSupport implements
		SurveyDao {

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalAnswers()
	 */
	public int getTotalAnswers() {
		
		int rowCount = this.getJdbcTemplate().queryForInt("select count(*) as total from SURVEYANSWERSTBL");
		
		return rowCount;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalDoNotLoveKUAnswers()
	 */
	public int getTotalDoNotLoveKUAnswers() {
		
		int rowCount = this.getJdbcTemplate().queryForInt("select count(*) as total from SURVEYANSWERSTBL where answer = 2");
		
		return rowCount;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalLoveKUAnswers()
	 */
	public int getTotalLoveKUAnswers() {
		
		int rowCount = this.getJdbcTemplate().queryForInt("select count(*) as total from SURVEYANSWERSTBL where answer = 3");
		
		return rowCount;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#getTotalNotSureLoveKUAnswers()
	 */
	public int getTotalNotSureLoveKUAnswers() {
		
		int rowCount = this.getJdbcTemplate().queryForInt("select count(*) as total from SURVEYANSWERSTBL where answer = 1");
		
		return rowCount;
		
	}

	/* (non-Javadoc)
	 * @see edu.ku.it.si.lovekusurvey.dao.SurveyDao#saveSurveyAnswer(int)
	 */
	public void saveSurveyAnswer(int answer) {

		SimpleJdbcInsert insertAnswer = 
			new SimpleJdbcInsert(this.getDataSource())
		     .withTableName("surveyAnswersTbl").usingGeneratedKeyColumns("id");


        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("answer", answer );
       
        insertAnswer.execute(parameters);

	}

}
