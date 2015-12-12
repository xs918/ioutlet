package sg.com.ioutlet.ace.user.contr;

import java.math.BigDecimal;
import java.util.List;

import sg.com.ioutlet.ace.plan.Plan;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.bas.CommonPojoKey;

public class UserContr extends CommonPojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserContrKey key;
	private User user;
	private Plan plan;
	private BigDecimal price;
	@Override
	public String entityName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CommonPojoKey getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setKey(CommonPojoKey key) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Object[]> getFields() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void initialize(Object... objects) {
		// TODO Auto-generated method stub
		
	} 
	

}
