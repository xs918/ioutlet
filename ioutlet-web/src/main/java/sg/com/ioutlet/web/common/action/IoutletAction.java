package sg.com.ioutlet.web.common.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import sg.com.ioutlet.model.IoutletFunction;
import sg.com.ioutlet.web.main.menu.MenuFactory;
import sg.com.ioutlet.web.main.menu.MenuGroup;
import sg.com.ioutlet.web.main.menu.MenuLink;

import com.opensymphony.xwork2.ActionSupport;

public abstract class IoutletAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static final String EMPTY = ""; 
	public static final String BUCKET="ioutlet";
	
	protected HttpServletRequest request;
	
	@SuppressWarnings("rawtypes")
	protected Map session;
	@SuppressWarnings("rawtypes")
	protected Map application;


	@SuppressWarnings("rawtypes")
	protected Map parameter;
	
	
	public String input()
	{
		return onLoad();
	}
	public String preOnLoad()
	{
		// if there is a requirement to perform some action before onload, override this method
		return INPUT;
	}
	protected abstract String onLoad();
	public void postOnLoad()
	{
		// if there is a requirement to perform post onload, override this method
	}
	


	public String getUserId()
	{
		return request.getRemoteUser();
	}

	public abstract String getDomainId();

	public abstract String getFunctionId();

	protected Set<IoutletFunction> availableFunctionIds;

	private AccessController accessControl;

	public Set<IoutletFunction> getAvailableFunctionIds()
	{
		return this.availableFunctionIds;
	}

	public void setAvailableFunctionIds(Set<IoutletFunction> availableFunctionIds)
	{
		this.availableFunctionIds = availableFunctionIds;
	}

	public boolean getAuthorizedToAccess(String functionId)
	{
		if (availableFunctionIds == null)
		{
		 	return false;
		}
		availableFunctionIds.contains(functionId);
		return false;
	}

	/**
	 * Find the object from all scope (parameter, session and application)
	 * 
	 * @param key
	 * @return
	 */
	protected Object findFromAllScope(String key)
	{
		Object obj = parameter.get(key);
		if (obj != null) return obj;

		obj = session.get(key);
		if (obj != null) return obj;

		obj = application.get(key);
		if (obj != null) return obj;
		return null;
	}
	public AccessController getAccessControl()
	{
		return this.accessControl;
	}
	
	public List<MenuGroup> getMenuItems() 
	{
		MenuFactory mf=new MenuFactory();
		if(accessControl==null)
		{
			Set<IoutletFunction> availableFunctionIds = new HashSet<IoutletFunction>();
			availableFunctionIds.add(IoutletFunction.ALL_FUNC);
			
			accessControl = new AccessController(availableFunctionIds);
		}
		List<MenuGroup>  m1=mf.generateMenus(IoutletFunction.IOLT_SIDE_MENU.inModule(), getAccessControl());
		return m1;
		
	}

	public Map<String,MenuLink> getMenuLinks()
	{
		List<MenuGroup> mg;
		Map<String,MenuLink> menumMap=new HashMap<String,MenuLink>();
		MenuFactory mf=new MenuFactory();
		
		
		mg=mf.generateMenus(IoutletFunction.IOLT_SIDE_MENU.inModule(), getAccessControl());
		
		if(mg!=null && mg.size()>0)
		{		
			Collection<MenuLink> mNL=mg.get(0).getMenus().values();
			Iterator<MenuLink> i=mNL.iterator();		
			menumMap.put(IoutletFunction.IOLT_SIDE_MENU.inModule(),i.next());
		}
		
        return menumMap;
		
	
		
	}

	public String getPageContentHeader() {

		return EMPTY;
	}
	public String getPageOptionaldescription() {
	
		return EMPTY;
	}

}
