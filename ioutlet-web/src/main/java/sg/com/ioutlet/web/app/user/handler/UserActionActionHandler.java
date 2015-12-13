package sg.com.ioutlet.web.app.user.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.ace.user.img.Imge;
import sg.com.ioutlet.web.app.user.form.UserRegistForm;
import sg.com.ioutlet.web.common.handler.IoutletActionHandler;

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
		    	
		    String fullPath=form.getSaveDirectory() + File.separator + form.getUserId();
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
		if (!this.uploadFiles(form.getUserImgFiles(), form.getUsrImgs()))
		{
		
		  return false;
		}
		this.deleteFile(form.getUsrImgs());
		return true;
		//return setterBridge.registeUserProfile(form.getRegUser(),form.getUsrImgs());
	   
	}



}
