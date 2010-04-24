package org.apache.struts.edit.action;

import java.util.Arrays;
import java.util.List;

import org.apache.struts.edit.model.Person;
import org.apache.struts.edit.service.EditService;
import org.apache.struts.edit.service.EditServiceInMemory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Acts as a controller to handle actions
 * related to editing a Person.
 * @author bruce phillips
 *
 */
public class EditAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private EditService editService = new EditServiceInMemory();
	
	private Person personBean;
	
	private String [] sports = {"football", "baseball", "basketball" };
	
	private String [] genders = {"male", "female", "not sure" };


	public String execute() throws Exception {
		
	    editService.savePerson( getPersonBean() );
		
		return SUCCESS;
		
	}
	
	
	public String input() throws Exception {
		
		setPersonBean( editService.getPerson() );
		
		return INPUT;
	}
	
	public Person getPersonBean() {
		
		
		return personBean;
		
	}
	
	public void setPersonBean(Person person) {
		
		personBean = person;
		
	}


	public List<String> getSports() {
		return Arrays.asList(sports);
	}
	
	public List<String> getGenders() {
		
		return Arrays.asList(genders);
		
	}

}
