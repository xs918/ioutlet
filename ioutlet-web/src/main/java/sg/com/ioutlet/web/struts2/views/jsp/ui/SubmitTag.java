/**
 * Copyright (C) 2011 KPMG Business Advisory Singapore . All Rights Reserved. 
 * 
 * This software is the proprietary information of KPMG Business Advisory Singapore. 
 * Use is subjected to license terms. 
 *
 * @since 22 Jan 2011 16:44:31
 * @author sandarwin
 * @fp-custom-stag
 *
 * Version Control Info
 *
 * $Id: codetemplates.xml,v 1.1 2008/08/21 01:32:51 sandarwin Exp $
 * $Revision: 1.1 $
 * $Date: 2008/08/21 01:32:51 $
 */
package sg.com.ioutlet.web.struts2.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import sg.com.ioutlet.web.struts2.components.Submit;

import com.opensymphony.xwork2.util.ValueStack;

public class SubmitTag extends org.apache.struts2.views.jsp.ui.SubmitTag
{
	private static final long serialVersionUID = 5811285953670562288L;

	protected String isfirst;
	protected String islast;
	protected String colspan;

	public SubmitTag()
	{
		super();
		//System.out.println("sandar -- newing SubmitTag");
	}
	
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res)
	{
		/*System.out.println("sandar -- getBean");
		System.out.println("sandar -- stack:" + stack.getContext());
		System.out.println("sandar -- req:" + req.getParameterMap());*/
		return new Submit(stack, req, res);
	}

	protected void populateParams()
	{
		super.populateParams();

		Submit submit = ((Submit) component);
		//System.out.println("sandar -- in PopulateParams : " + isfirst + ", " + islast);
		submit.setIsfirst(isfirst);
		submit.setIslast(islast);
		submit.setColspan(colspan);
	}
	
	public void setIsfirst(String isfirst)
	{
		//System.out.println("sandar -- SubmitTag setIsfirst");
		this.isfirst = isfirst;
	}
	
	public void setIslast(String islast)
	{
		//System.out.println("sandar -- SubmitTag setIslast");
		this.islast = islast;
	}
	
	public void setColspan(String colspan)
	{
		//System.out.println("sandar -- SubmitTag setColspan");
		this.colspan = colspan;
	}
}
