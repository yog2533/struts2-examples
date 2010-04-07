package edu.ku.it.si.lovekusurvey.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration //if no location is specified will look for TestSurveyService-context.xml in this package
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSurveyService {
	
	@Autowired
	private SurveyService surveyService;
	
	private final Logger log = Logger.getLogger(this.getClass());

	@Test
	public void testGetPercentageDoNotLoveKU() {
		
		int noPercentage = surveyService.getPercentageDoNotLoveKU() ;
		log.info("Percentage who do not love KU: " + noPercentage);
		assertEquals("Percentage who do not love KU is NOT 21, but should be.", 21, noPercentage);
		
		
		
	}

	@Test
	public void testGetPercentageLoveKU() {
		
		int yesPercentage = surveyService.getPercentageLoveKU() ;
		log.info("Percentage who love KU: " + yesPercentage);
		assertEquals("Percentage who love KU is NOT 66, but should be.", 66, yesPercentage);


	}

	@Test
	public void testGetPercentageNotSureLoveKU() {
		
		int notSurePercentage = surveyService.getPercentageNotSureLoveKU();
		log.info("Percentage who are not sure they love KU: " + notSurePercentage);
		assertEquals("Percentage who are not sure they love KU is NOT 11, but should be.", 11, notSurePercentage);

	}
	
	@Test
	public void testSaveAnswerValidAnswers() {
		
		int answer = 1 ;
		
		surveyService.saveAnswer(answer);
		int notSurePercentage = surveyService.getPercentageNotSureLoveKU();
		log.info("Percentage who are not sure they love KU: " + notSurePercentage);
		assertEquals("Percentage who are not sure they love KU is NOT 12, but should be.", 12, notSurePercentage);

		answer = 2;
		surveyService.saveAnswer(answer);
		int noPercentage = surveyService.getPercentageDoNotLoveKU() ;
		log.info("Percentage who do not love KU: " + noPercentage);
		assertEquals("Percentage who do not love KU is NOT 22, but should be.", 22, noPercentage);
		
		answer = 3;
		surveyService.saveAnswer(answer);
		int yesPercentage = surveyService.getPercentageLoveKU() ;
		log.info("Percentage who love KU: " + yesPercentage);
		assertEquals("Percentage who love KU is NOT 66, but should be.", 66, yesPercentage);

		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSaveAnswerIllegalAnswer() {
		
		int answer = 4;
		
		//below should cause an IllegalArgumentException
		surveyService.saveAnswer(answer);
		
	}
	
	

}
