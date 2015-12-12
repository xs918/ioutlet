package sg.com.ioutlet.web.app.user.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.ace.user.img.UserImg;
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
	
	public void doUpload(UserRegistForm form)
	{
		List<UserImg> usrImgs = new ArrayList<UserImg>();
		
		
		 for (int i = 0; i < form.getUserImgFile().length; i++) {
			 
			File destFile = new File(form.getSaveDirectory() + File.separator + form.getUserId()+i);
			File uploadedFile = form.getUserImgFile()[i];
			try {
                FileUtils.copyFile(uploadedFile, destFile);
            } catch (IOException ex) {
                System.out.println("Could not copy file " + uploadedFile.getName());
             
                this.addActionError(getText("upload.file.failed:"+uploadedFile.getName()));
               
                 for(int j=0;j<=i;j++)
                 {
                 	 
                	 File deleteFile = new File(form.getSaveDirectory() + File.separator + form.getUserId()+j);
                 	 try {
						FileUtils.forceDelete(deleteFile);
					} catch (IOException e) {
					
						   this.addActionError(getText("rollback.upload.file.failed:"+form.getUserId()+j));
						
					}
                  	 
                 }

                 this.addActionError(ex.getMessage());
            	return;
            }
			 
			UserImg usrImg = new UserImg();
			usrImg.setUser(form.getRegUser());
			usrImg.setImgName(destFile.getName());
			usrImg.setImgUrl(destFile.getAbsolutePath());
			usrImgs.add(usrImg);
			
		}
		
		form.setUsrImgs(usrImgs);
	
	}
	
	
	public boolean registeUserProfile(UserRegistForm form) {
		this.createUserObject(form);
		this.doUpload(form);
		return setterBridge.registeUserProfile(form.getRegUser(),form.getUsrImgs());
	   
	}



}
