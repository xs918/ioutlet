package sg.com.ioutlet.ace.user;

public enum UserStatus
{
	A("A", "Active", "userprofile.status.A"),
	S("S", "Suspend", "userprofile.status.S");
	private String code;
	private String desc;
	private String lblDesc;
	private UserStatus(String code, String desc, String lblDesc)
	{
		this.code = code;
		this.desc = desc;
		this.lblDesc = lblDesc;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getLblDesc()
	{
		return lblDesc;
	}
	public void setLblDesc(String lblDesc)
	{
		this.lblDesc = lblDesc;
	}
	
	
}
