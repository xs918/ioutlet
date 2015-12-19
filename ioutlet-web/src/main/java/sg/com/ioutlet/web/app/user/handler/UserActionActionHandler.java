package sg.com.ioutlet.web.app.user.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.framework.web.common.OssUtils;
import sg.com.ioutlet.model.img.Imge;
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
		
	}

	public void createUserObject(UserRegistForm form)
	{
		User usr = new User();
		usr.setUserId(form.getUserId());
		usr.setName(form.getName());
		usr.setEmailId(form.getEmailId());
		usr.setPassword(form.getPassword());
		usr.setGender(form.getGender());
		usr.setDayOfBirth(form.getDayOfBirth());
		usr.setDescription(form.getDescription());
		usr.setAddress1(form.getAddress1());
		usr.setAddress2(form.getAddress2());
		usr.setAddress3(form.getAddress3());
		usr.setPostCode(form.getPostCode());
		usr.setLangCode(form.getLangCode());
		usr.setCurrLoc(form.getCurrLoc());
		usr.setRewardPoint(form.getRewardPoint());
		usr.setLocked(false);
		usr.setLoginFailureAttempt(0);
		usr.setLastLoginTime(null);
		usr.setActiveTime(null);
		usr.setLastPasswordChangedTime(null);
		usr.setLastLockedTime(null);
		
		form.setRegUser(usr);

		return;
		
	}
	
	
	public void createUserImgObjs(UserRegistForm form)
	{
		List<Imge> usrImgs = new ArrayList<Imge>();
		
		
		 for (int i = 0; i < form.getUserImgFiles().length; i++) {
			 
		
		    String extName =FilenameUtils.getExtension(form.getUserImgFilesFileName()[i]);
		    	
		    String fullPath=form.getRegUser().entityName() + OssUtils.CLOUD_PATH_SEPARATOR + form.getUserId();
		    String imgName=i+"."+extName;
		  

	
	
			Imge usrImg = new Imge();
			usrImg.setUser(form.getRegUser());
			usrImg.setFullPath(fullPath);
			usrImg.setImgName(imgName);
			usrImgs.add(usrImg);
			
		}
		
		form.setUsrImgs(usrImgs);
	
	}
	
	
	public boolean registeUserProfile(UserRegistForm form) {
		this.createUserObject(form);
		this.createUserImgObjs(form);
		
		
	
		try
		{
			  this.uploadFiles(form.getUserImgFiles(), form.getUsrImgs());
			
		} 
		catch (IOException e) 
		{
				
			this.addActionError(getText("upload.file.failed")+e.getMessage());
			return false;
		}

		
		boolean isSuccess= aceBridge.registeUserProfile(form.getRegUser(),form.getUsrImgs());
		if(!isSuccess) // remove file from list
		{
			this.deleteFile(form.getUsrImgs());
		}
		
	   return isSuccess;
	}



}
