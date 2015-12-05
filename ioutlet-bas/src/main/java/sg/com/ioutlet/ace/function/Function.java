
package sg.com.ioutlet.ace.function;

import java.util.Collection;

import sg.com.ioutlet.ace.domain.Domain;
import sg.com.ioutlet.ace.functionaccess.FunctionAccess;

public class Function 
{

	
	private String id;

	
	private String name;

	
	private String description;

	
	private String action;

	
	private String namespace;

	
	private boolean available;
	
	
	private boolean menuItem;

	
	private int displayIndex;

	
	private Domain domain;


	
	private Collection<FunctionAccess> functionAccesses;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}

	public boolean isAvailable()
	{
		return available;
	}

	public void setAvailable(boolean available)
	{
		this.available = available;
	}

	public int getDisplayIndex()
	{
		return displayIndex;
	}

	public void setDisplayIndex(int displayIndex)
	{
		this.displayIndex = displayIndex;
	}

	
	public Domain getDomain()
	{
		return domain;
	}

	public void setDomain(Domain domain)
	{
		this.domain = domain;
	}

	
	public Collection<FunctionAccess> getFunctionAccesses()
	{
		return functionAccesses;
	}

	public void setFunctionAccesses(Collection<FunctionAccess> functionAccesses)
	{
		this.functionAccesses = functionAccesses;
	}

	public boolean isMenuItem()
	{
		return menuItem;
	}

	public void setMenuItem(boolean menuItem)
	{
		this.menuItem = menuItem;
	}
	
	
	public String getRecordReference()
	{
		return domain.getId()+"."+id;		
	}
}
