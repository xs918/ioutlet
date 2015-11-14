package sg.com.ioutlet.model;

public enum Rating
{
	EXCELLENT("1"),VERYGOOD("2"),GOOD("3"),SATISFIED("4"),UNSATISFIED("5");
	
	private String code;	
	
	
	Rating(String RatingCode)
	{
		this.setCode(RatingCode);
	}



	public String toString()
	{
		return this.name();
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}
	
}
