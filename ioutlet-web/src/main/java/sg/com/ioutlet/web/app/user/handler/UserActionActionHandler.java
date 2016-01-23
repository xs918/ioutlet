package sg.com.ioutlet.web.app.user.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FilenameUtils;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.DateUtil;
import sg.com.ioutlet.bas.Gender;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.common.OssUtils;
import sg.com.ioutlet.model.bizinfo.BizInfo;
import sg.com.ioutlet.model.image.Image;
import sg.com.ioutlet.web.app.user.form.UserRegistForm;
import sg.com.ioutlet.web.common.handler.IoutletActionHandler;

import com.opensymphony.xwork2.ActionSupport;

public class UserActionActionHandler extends  IoutletActionHandler{



	public UserActionActionHandler(ActionSupport action) {
		super(action);
	
	}

	public void loadDefaultValue(UserRegistForm form) {
		form.setLangMap(this.getLangMap());
		form.setGenderMap(this.getGenderMap());
		form.setLocMap(this.getLocMap());
		
		Map<Role,List<FunctionAccess>> funAceMap = this.getAllRolesWithFunction();
		
		
		form.setAllRoleFunctionAccessMap(funAceMap);
		Map<String,Role> rolesMap = new TreeMap<String,Role>();
		for(Role r:funAceMap.keySet())
		{
			if(r.isDefault())
			{
					form.setSelectedRole(r);
			        form.setSelectedRoleName(r.getName());
			}
			rolesMap.put(r.getName(), r);
		}
		form.setRolesMap(rolesMap);
		form.populateSelectedFunctionName();
		
		
	}




	public void createUserObject(UserRegistForm form)
	{
		User usr = new User();
		usr.setUserId(form.getUserId());
		usr.setName(form.getName());
		usr.setEmailId(form.getEmailId());
		usr.setPassword(form.getPassword());
		usr.setGender(Gender.valueOf(form.getGender()));

		usr.setDayOfBirth(DateUtil.toDateFromString(form.getDayOfBirth()));
		usr.setDescription(form.getDescription());
		usr.setLangCode(form.getLangCode());
		usr.setCurrLoc(form.getCurrLoc());
		usr.setRewardPoint(form.getRewardPoint());
		usr.setLocked(false);
		usr.setLoginFailureAttempt(0);
		usr.setLastLoginTime(null);
		usr.setActiveTime(null);
		usr.setLastPasswordChangedTime(null);
		usr.setLastLockedTime(null);
		usr.setRole(form.getSelectedRole());
		
		
		BizInfo bizinfo = new BizInfo();
		bizinfo.setRegId(form.getRegNoOfCompany());
		bizinfo.setRegName(form.getNameOfCompany());
		bizinfo.setTelPhone(form.getTelephone());
		bizinfo.setAddr1(form.getAddress1());
		bizinfo.setAddr2(form.getAddress2());
		bizinfo.setAddr3(form.getAddress3());
		bizinfo.setPostCode(form.getPostCode());
		bizinfo.setUser(usr);
		usr.setBizinfo(bizinfo);
		
		form.setRegUser(usr);

		return;
		
	}
	
	
	public void createUserImageObjs(UserRegistForm form)
	{
		List<Image> usrImages = new ArrayList<Image>();
		
		if(form.getUserImageFiles()!=null)
		{
			
			for (int i = 0; i < form.getUserImageFiles().length; i++) {
				File f = form.getUserImageFiles()[i];
				
			   File fcheck =  new File(f.getAbsolutePath());
			   if(fcheck.exists()&&fcheck.isFile())
			   {
				
				   String extName =FilenameUtils.getExtension(form.getUserImageFilesFileName()[i]);
				   String fullPath=form.getRegUser().entityName() + OssUtils.CLOUD_PATH_SEPARATOR + form.getUserId();
				   String imageName=i+"."+extName;
				  
			
					Image usrImage = new Image();
					usrImage.setUser(form.getRegUser());
					usrImage.setFullPath(fullPath);
					usrImage.setImageName(imageName);
					usrImages.add(usrImage);
				}
				
			}
			
			form.setUsrImages(usrImages);
		}
	
	}
	
	
	public boolean registeUserProfile(UserRegistForm form) {
		User usr= aceBridge.getUserById(form.getUserId());
		if(null!=usr)
		{
			addFieldError("userId", getText("user.id.has.been.existed.please.choose.new.one"));
			return false;
		}
		
		this.createUserObject(form);
		this.createUserImageObjs(form);
		
		
	  
		try
		{
			  this.uploadFiles(form.getUserImageFiles(), form.getUsrImages());
			
		} 
		catch (IOException e) 
		{
				
			this.addActionError(getText("upload.file.failed")+e.getMessage());
			return false;
		}

		
		boolean isSuccess= aceBridge.registeUserProfile(form.getRegUser(),form.getUsrImages(),TransactionControl.getTransactionInfo());
		if(!isSuccess) // remove file from list
		{
			this.deleteFile(form.getUsrImages());
		}
		
	   return isSuccess;
	}

	public User userLogin(String userId, String password) {
		User loginUser = aceBridge.getUserById(userId);
		if(loginUser==null||!loginUser.isPasswordMatch(password))
		{
			return null;
		}
		
		return loginUser;
	}



}
