package edu.ku.it.si.lovekusurvey.action;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.Action;


public class TestSurveyAction extends StrutsSpringTestCase {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public String getContextLocations() {
		
		return "edu/ku/it/si/lovekusurvey/action/TestSurveyAction-context.xml";
		
	}
	
	
    public void testGetActionMapping() {
        ActionMapping mapping = getActionMapping("/saveAnswer.action");
        assertNotNull(mapping);
        assertEquals("/", mapping.getNamespace());
        assertEquals("saveAnswer", mapping.getName());
    }

    
    public void testGetActionProxy() throws Exception {
    	
        //set parameters before calling getActionProxy
        request.setParameter("answer", "3");

        ActionProxy proxy = getActionProxy("/saveAnswer");
        assertNotNull(proxy);

       SurveyAction action = (SurveyAction) proxy.getAction();
        assertNotNull(action);
        

        String result = proxy.execute();
        assertEquals("success not returned from calling action class", Action.SUCCESS, result);
        assertEquals("3 not value of answer", 3, action.getAnswer() );
    
    }
    
    public void testIllegalAnswerValue() throws Exception {
    	
    	request.setParameter("answer", "4");

    	ActionProxy proxy = getActionProxy("/saveAnswer");
    	SurveyAction surveyAction = (SurveyAction) proxy.getAction();

        String result = proxy.execute();
        assertEquals("input not returned from calling action class", Action.INPUT, result);
        assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", surveyAction.getFieldErrors().size() == 1);
		assertTrue("Problem field answer not present in fieldErrors but it should have been",
				surveyAction.getFieldErrors().containsKey("answer") );
   
    }
    
    public void testNoAnswerValue() throws Exception {
    	
       //do not set a value for answer in the request scope    	
    	
    	ActionProxy proxy = getActionProxy("/saveAnswer");
    	SurveyAction surveyAction = (SurveyAction) proxy.getAction();
    	
    	log.info("Answer value is " + surveyAction.getAnswer() );

        String result = proxy.execute();
        assertEquals("input not returned from calling action class", Action.INPUT, result);
        assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", surveyAction.getFieldErrors().size() == 1);
		assertTrue("Problem field answer not present in fieldErrors but it should have been",
				surveyAction.getFieldErrors().containsKey("answer") );
 
    	
    }
    
    
    public void testExecute() throws Exception {
    	
    	request.setParameter("answer", "3");
    	
       	ActionProxy proxy = getActionProxy("/saveAnswer");

        SurveyAction action = (SurveyAction) proxy.getAction();
        assertNotNull(action);

        String result = proxy.execute();
        assertEquals("success not returned from calling action class", Action.SUCCESS, result);
        assertEquals("3 not value of answer", 3, action.getAnswer() );
        
        log.info("Yes percentage is " + action.getYesPercentage() );
        log.info("No percentage is " + action.getNoPercentage() );
        log.info("Not sure percentage is " + action.getNotSurePercentage() );
        
        assertEquals("yesPercentage not equal to 70, but it should be", 70, action.getYesPercentage() );
        assertEquals("noPercentage not equal to 20, but it should be", 20, action.getNoPercentage() );
        assertEquals("notSurePercentage not equal to 10, but it should be", 10, action.getNotSurePercentage() );
    	
    }
    
   


}
