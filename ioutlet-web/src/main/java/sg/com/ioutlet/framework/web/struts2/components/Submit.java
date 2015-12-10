
package sg.com.ioutlet.framework.web.struts2.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name = "submit", tldTagClass = "sg.com.kpmg.factorpro.web.struts2.views.jsp.ui.SubmitTag", description = "Render submit input type", allowDynamicAttributes = true)
public class Submit extends org.apache.struts2.components.Submit
{
	public String isfirst;
	public String islast;
	public String colspan;
	
	public Submit(ValueStack stack, HttpServletRequest request, HttpServletResponse response)
	{
		super(stack, request, response);
		//System.out.println("sandar -- new Submit components");
	}

	public void evaluateExtraParams()
	{
		super.evaluateExtraParams();

		if (isfirst != null)
		{
			addParameter("isfirst", findValue(isfirst, Boolean.class));
		}
		
		if (islast != null)
		{
			addParameter("islast", findValue(islast, Boolean.class));
		}
		
		if (colspan != null)
		{
			addParameter("colspan", findValue(colspan, Number.class));
		}
		
		/*System.out.println("sandar -- call evaluateExtraParams");
		System.out.println("sandar -- print out parameters "); 
		java.util.Map pm = getParameters();
		for(Object o : pm.keySet())
		{
			System.out.println("sandar -- key: " + o + ", value : "+ pm.get(o));
			if( ((String)o).equalsIgnoreCase("dynamicAttributes") )
				System.out.println("sandar -- getClass of dynamic :" + pm.get(o).getClass().toString());
		}*/
		
	}

	@StrutsTagAttribute(description = "Isfirst", type = "Boolean", defaultValue = "false")
	public void setIsfirst(String isfirst)
	{
		this.isfirst = isfirst;
		//System.out.println("sandar -- components -- settingIsFirst");
	}
	
	@StrutsTagAttribute(description = "Islast", type = "Boolean", defaultValue = "false")
	public void setIslast(String islast)
	{
		this.islast = islast;
		//System.out.println("sandar -- components -- settingIsLast");
	}
	
	@StrutsTagAttribute(description = "Colspan", type = "Number", defaultValue = "false")
	public void setColspan(String colspan)
	{
		this.colspan = colspan;
		//System.out.println("sandar -- components -- settingColspan");
	}
}
