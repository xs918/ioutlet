package sg.com.ioutlet.web.common.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;
import sg.com.ioutlet.framework.web.action.awareness.AuthorizationAware;
import sg.com.ioutlet.web.main.menu.MenuFactory;
import sg.com.ioutlet.web.main.menu.MenuGroup;
import sg.com.ioutlet.web.main.menu.MenuLink;

public abstract  class IoutletDisplayAction extends CommonActionSupport  implements AuthorizationAware  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DOMAIN_ID = "IOLT";

	
	private User userProfile;
	@Override
	public void setUserProfile(User user) {

		userProfile = user;
		
	}
	
	public User getUserProfile()
	{
		return userProfile;
		
	}
	
	

	public List<MenuGroup> getMenuItems() {
		MenuFactory mf = new MenuFactory();
		if (accessControl == null) {
			Set<IoltFunction> availableFunctionIds = new HashSet<IoltFunction>();
			availableFunctionIds.add(IoltFunction.ALL_FUNC);

			accessControl = new AccessController(availableFunctionIds);
		}
		List<MenuGroup> m1 = mf.generateMenus(
				IoltFunction.IOLT_SIDE_MENU.inModule(), getAccessControl());
		return m1;

	}

	public Map<String, MenuLink> getMenuLinks() {
		List<MenuGroup> mg;
		Map<String, MenuLink> menumMap = new HashMap<String, MenuLink>();
		MenuFactory mf = new MenuFactory();

		mg = mf.generateMenus(IoltFunction.IOLT_SIDE_MENU.inModule(),
				getAccessControl());

		if (mg != null && mg.size() > 0) {
			Collection<MenuLink> mNL = mg.get(0).getMenus().values();
			Iterator<MenuLink> i = mNL.iterator();
			menumMap.put(IoltFunction.IOLT_SIDE_MENU.inModule(), i.next());
		}

		return menumMap;

	}

	public String getPageContentHeader() {

		return EMPTY;
	}

	public String getPageOptionaldescription() {

		return EMPTY;
	}

	public String getImagePath() {
		return IMG_PATH;
	}

	public String getUserProfileImageLink() {
		
		String userImageUrl="";
		if(userProfile!=null && userProfile.getUserImg()!=null)
		{
			userImageUrl = userProfile.getUserImg().get(0).getImgUrl();
		}
		
		
		if(StringUtils.isBlank(userImageUrl))
		{
			userImageUrl=IMG_PATH + "/" + "user3-128x128.jpg";
		}
		
		return userImageUrl;
			
			
	}
	
	




	protected String validateOnSubmit = TRUE;
	
	public String getValidateOnSubmit()
	{
		return this.validateOnSubmit;
	}
	public void setValidateOnSubmit(String validateOnSubmit)
	{
		this.validateOnSubmit = validateOnSubmit;
	}

	
	@Override
	public boolean requiredValidationOnSubmit()
	{
		return TRUE.equals(validateOnSubmit);
	}
	
	
	
	@Override
	public String getDomainId() {
		return DOMAIN_ID;
	}

	public void setUserProfileImageLink(String userProfileImageLink) {
	}





}
