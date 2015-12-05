package sg.com.ioutlet.bas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class CommonPojo implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String ACTIVE_YES = "Y";

	public static final String ACTIVE_NO = "N";

	
	
	
	public enum RecordStatus
	{
		A("A-ACTIVE"), C("C-CANCELLED");

		private String s;

		private RecordStatus(String s)
		{
			this.s = s;
		}

		public String toString()
		{
			return s;
		}
	}

	private Date creationTime;

	private String ludUser;

	private Date ludTime;

	private String ludPgm;

	private RecordStatus recordStatus;
	

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}


	public enum PersistenceDirection
	{
		NONE, LOAD, STORE
	}

	protected CommonPojo()
	{
	}

	public CommonPojo( CommonPojoKey key) {
	}


	public abstract String entityName();

	

	public abstract CommonPojoKey getKey();

	public abstract void setKey(CommonPojoKey key);

	
	@Override
	public final boolean equals(Object obj)
	{
		if (!(obj instanceof CommonPojo))
		{
			return false;
		}

		if (this == obj)
		{
			return true;
		}

		CommonPojo another = (CommonPojo) obj;
		return getKey().equals(another.getKey());
	}

	@Override
	public final String toString()
	{
		ToStringBuilder tsb = new ToStringBuilder(this, ObjectStringUtil.createToStringStyle());
		tsb.appendSuper(super.toString());
	
		List<Object[]> fields = getFields();
		for (Object[] field : fields)
		{
			tsb.append((String) field[0], field[1]);
		}
		return tsb.toString();
	}

	public final int compareTo(CommonPojo e)
	{
		CommonPojo another = (CommonPojo) e;
		return getKey().compareTo(another.getKey());
	}

	public abstract List<Object[]> getFields();

	public abstract void initialize(Object... objects);
	
	
	public void prepareCreate()
	{
		recordStatus=RecordStatus.A;
		creationTime = new Date();
		ludTime =	 new Date();
	
	}

	public void prepareUpdate()
	{
		if(creationTime == null)
			creationTime = new Date();
		
		recordStatus=RecordStatus.A;
		ludTime =	 new Date();
	}

	
	
	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getLudUser() {
		return ludUser;
	}

	public void setLudUser(String ludUser) {
		this.ludUser = ludUser;
	}

	public Date getLudTime() {
		return ludTime;
	}

	public void setLudTime(Date ludTime) {
		this.ludTime = ludTime;
	}

	public String getLudPgm() {
		return ludPgm;
	}

	public void setLudPgm(String ludPgm) {
		this.ludPgm = ludPgm;
	}


	public RecordStatus getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(RecordStatus recordStatus) {
		this.recordStatus = recordStatus;
	}




}
