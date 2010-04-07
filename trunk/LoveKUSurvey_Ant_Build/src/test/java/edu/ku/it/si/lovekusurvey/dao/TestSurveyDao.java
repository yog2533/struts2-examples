package edu.ku.it.si.lovekusurvey.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration //if no location is specified will look for TestSurveyDao-context.xml in this package
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSurveyDao {
	
	@Autowired
	private SurveyDao surveyDao;
	
	private final Logger log = Logger.getLogger(this.getClass());

	@Test
	public void testGetTotalAnswers() {

		int totalAnswers = surveyDao.getTotalAnswers();
		log.info("Total Answers: " + totalAnswers);
		assertEquals("Total answers is not 100 but should be.", 100, totalAnswers);

	}

	@Test
	public void testGetTotalDoNotLoveKUAnswers() {
		
		int totalNoAnswers = surveyDao.getTotalDoNotLoveKUAnswers() ;
		log.info("Total No Answers: " + totalNoAnswers);
		assertEquals("Total No answers is not 20 but should be.", 20, totalNoAnswers);
		
	}

	@Test
	public void testGetTotalLoveKUAnswers() {
		
		int totalYesAnswers = surveyDao.getTotalLoveKUAnswers() ;
		log.info("Total Yes Answers: " + totalYesAnswers);
		assertEquals("Total Yes answers is not 70 but should be.", 70, totalYesAnswers);
		
	}

	@Test
	public void testGetTotalNotSureLoveKUAnswers() {
		
		int totalNotSureAnswers = surveyDao.getTotalNotSureLoveKUAnswers() ;
		log.info("Total Not Sure Answers: " + totalNotSureAnswers);
		assertEquals("Total Not Sure answers is not 10 but should be.", 10, totalNotSureAnswers);
	}

	@Test
	public void testSaveSurveyAnswer() {
		
		int answer = 1;
		surveyDao.saveSurveyAnswer(answer);
		int totalAnswers = surveyDao.getTotalAnswers();
		log.info("Total Answers: " + totalAnswers);
		assertEquals("Total answers is not 101 but should be.", 101, totalAnswers);
		int totalNotSureAnswers = surveyDao.getTotalNotSureLoveKUAnswers() ;
		log.info("Total Not Sure Answers: " + totalNotSureAnswers);
		assertEquals("Total Not Sure answers is not 11 but should be.", 11, totalNotSureAnswers);
		
		answer = 2;
		surveyDao.saveSurveyAnswer(answer);
		totalAnswers = surveyDao.getTotalAnswers();
		log.info("Total Answers: " + totalAnswers);
		assertEquals("Total answers is not 102 but should be.", 102, totalAnswers);
		int totalNoAnswers = surveyDao.getTotalDoNotLoveKUAnswers() ;
		log.info("Total No Answers: " + totalNoAnswers);
		assertEquals("Total No answers is not 21 but should be.", 21, totalNoAnswers);
		
		answer = 3;
		surveyDao.saveSurveyAnswer(answer);
		totalAnswers = surveyDao.getTotalAnswers();
		log.info("Total Answers: " + totalAnswers);
		assertEquals("Total answers is not 103 but should be.", 103, totalAnswers);
		int totalYesAnswers = surveyDao.getTotalLoveKUAnswers() ;
		log.info("Total Yes Answers: " + totalYesAnswers);
		assertEquals("Total Yes answers is not 71 but should be.", 71, totalYesAnswers);

		


		
	}

}
