package sg.com.ioutlet.bas;

public enum Gender {

	
F("Female"),M("Male"),O("Other");

private String gender;	

Gender(String gender)
{
	this.setGender(gender);
}


private void setGender(String gender) {
	this.gender = gender;
	
}

public String getGender() {
	return gender;
}


public String toString()
{
	return this.gender;
}
}
