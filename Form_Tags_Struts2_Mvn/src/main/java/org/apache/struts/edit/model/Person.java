package org.apache.struts.edit.model;


/**
 * Models a Person who registers.
 * @author bruce phillips
 *
 */
public class Person
{
    private String firstName;
    private String lastName;
    private String sport;
    private String gender;
 

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }




	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public String getSport() {
		return sport;
	}

	public String toString()
    {
        return "First Name: " + getFirstName() + " | " +
        " Last Name:  " + getLastName() + " | " +
        " Favorite Sport: " + getSport() + " | " +
        " Gender: " + getGender() ;
        
    }
}
