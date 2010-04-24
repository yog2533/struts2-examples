package org.apache.struts.edit.service;

import org.apache.struts.edit.model.Person;
/**
 * Implement Services needed to edit and save
 * a Person object's state.  In this implementation
 * the Person object's state is stored in memory
 * @author brucephillips
 *
 */
public class EditServiceInMemory implements EditService {
	
	
	private static Person person ;
	
	static {
		person = new Person();
		person.setFirstName("Bruce");
		person.setLastName("Phillips");
		person.setSport("basketball");
		person.setGender("not sure");
	}

	
	public Person getPerson() {
		
		return EditServiceInMemory.person;
	}


	public void savePerson(Person personBean) {

		EditServiceInMemory.person.setFirstName(personBean.getFirstName() );
		EditServiceInMemory.person.setLastName(personBean.getLastName() );

	}

}
