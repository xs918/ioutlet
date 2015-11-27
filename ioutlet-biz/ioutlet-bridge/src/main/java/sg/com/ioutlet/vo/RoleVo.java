package sg.com.ioutlet.vo;

import java.util.Date;


public class RoleVo extends CommonVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5460006676348935751L;
	private String id;
	private String name;
	private Date startDate;
	private Date endDate;
	private String description;
	
	public RoleVo()
	{
		
	}
	
	
	public RoleVo(String id,String name,String description,Date startDate,Date endDate )
	{
		this.id = id;
		this.name  = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
