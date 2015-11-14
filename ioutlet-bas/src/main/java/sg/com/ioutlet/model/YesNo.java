package sg.com.ioutlet.model;

public enum YesNo {
    Y("Yes"),N("No");
	
	private String yesNo;	
	
	
	YesNo(String yesNo)
	{
		this.setYesNo(yesNo);
	}



	public String toString()
	{
		return this.name();
	}



	public String getYesNo() {
		return yesNo;
	}



	public void setYesNo(String yesNo) {
		this.yesNo = yesNo;
	}
	
}
