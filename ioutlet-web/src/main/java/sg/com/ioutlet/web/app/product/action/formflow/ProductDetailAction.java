package sg.com.ioutlet.web.app.product.action.formflow;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.From;

import org.apache.commons.lang3.StringUtils;

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.framework.authorization.model.IoltFunction;
import sg.com.ioutlet.framework.web.form.CommonForm;
import sg.com.ioutlet.model.discount.Discount;
import sg.com.ioutlet.web.app.product.form.ProductForm;
import sg.com.ioutlet.web.app.product.handler.ProductActionHandler;
import sg.com.ioutlet.web.app.user.form.UserRegistForm;
import sg.com.ioutlet.web.common.action.IoutletAction;

public class ProductDetailAction extends IoutletAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private List<File> file;
     private List<String> fileContentType;
     private List<String> fileFileName;
     private String jsonOption;
     

	@Override
	protected CommonForm constructForm() {
		
		return new ProductForm();
	}

	@Override
	protected String onSubmit() {
		
		System.out.println("onSubmit product detail");
		ProductForm form = (ProductForm) getModel();
		
		   int i = 0;
		   if(form.getFile()!=null)
	        for (File f : form.getFile()) {
	            System.out.print("\nFile [" + i + "] ");
	            System.out.print(" length: " + f.length());
	            System.out.print(" name:" + getFileFileName().get(i));
	            System.out.print(" contentType: " + getFileContentType().get(i));

	            i++;
	        }
	        System.out.println("\n---------------------------------------\n");
	       
			
			
		return SUCCESS;
	}
	
	
	public String doCustom()
	{
		ProductForm form = (ProductForm) getModel();
		if(StringUtils.equals(jsonOption, "PRD_DISCOUNT")){
			   System.out.println("doCustom");
			   List<Discount> dis = form.getDiscounts()==null?new ArrayList<Discount>():form.getDiscounts();
			   Discount d1 = new Discount();
			   d1.setName("Group1");
			   d1.setDiscountAmount(new BigDecimal(10.99));
			   d1.setDiscountRate(20);
			   d1.setQuantity(100);
			   d1.setStartDate(new Date());
			   d1.setEndDate(new Date());
			   dis.add(d1);
			   form.setDiscounts(dis);
			   jsonOption="";
			 
			}
		return SUCCESS;
	}
	
	public String json() {
		System.out.println("********************image uplaod***************************");
		ProductForm form = (ProductForm) getModel();
		if(StringUtils.equals(jsonOption, "PRD_DISCOUNT")){
		   System.out.println("PRD_DISCOUNT");
		   List<Discount> dis = form.getDiscounts()==null?new ArrayList<Discount>():form.getDiscounts();
		   Discount d1 = new Discount();
		   d1.setName("Group1");
		   d1.setDiscountAmount(new BigDecimal(10.99));
		   d1.setDiscountRate(20);
		   d1.setQuantity(100);
		   d1.setStartDate(new Date());
		   d1.setEndDate(new Date());
		   dis.add(d1);
		   form.setDiscounts(dis);
		   jsonOption="";
		   return SUCCESS;
		}
		
	
			return SUCCESS;
	}
	
	

	@Override
	public String getFunctionId() {
		return IoltFunction.IOLT_PRODUCTS.toString();
	}
	
	@Override
	protected String onLoad() {
		  ProductForm form = (ProductForm) getModel();
			
			ProductActionHandler handler = new ProductActionHandler(this);
			
			handler.intialProductDetail(form);
		
			return INPUT;
		
	}

	public List<File> getFiles() {
		System.out.println("getting file action");
		return file;
	}

	public void setFiles(List<File> file) {
		System.out.println("setting file action");
		this.file = file;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getJsonOption() {
		return jsonOption;
	}

	public void setJsonOption(String jsonOption) {
		this.jsonOption = jsonOption;
	}

}
