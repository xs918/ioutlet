package sg.com.ioutlet.web.common.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

import sg.com.ioutlet.ace.functionaccess.FunctionAccess;
import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.bas.Gender;
import sg.com.ioutlet.framework.web.common.OssUtils;
import sg.com.ioutlet.framework.web.handler.CommonActionHandler;
import sg.com.ioutlet.model.img.Image;

import com.opensymphony.xwork2.ActionSupport;

public class IoutletActionHandler  extends CommonActionHandler  {
	
	

	

	public IoutletActionHandler(ActionSupport action) {
		super(action);
	
	}

	public Map<Role,List<FunctionAccess>> getAllRolesWithFunction() {
      	return aceBridge.getAllRolesWithFunction();
		  	
		
		
	}
	public TreeMap<String,String> getGenderMap()
  	{
		TreeMap<String,String> genderMap  = new TreeMap<String,String>();
  		genderMap.put(Gender.F.name(), Gender.F.toString());
  		genderMap.put(Gender.M.name(), Gender.M.toString());
  		genderMap.put(Gender.O.name(), Gender.O.toString());
  		return genderMap;
  		
  	}
	
  	public TreeMap<String,String> getLangMap()
  	{
  		TreeMap<String,String> langMap  = new TreeMap<String,String>();
  		langMap.put("cn","Chinese");
  		langMap.put("jp", "Japanese");
  		langMap.put("en","English");
  		return langMap;
  		
  	}
	
  	
  	public TreeMap<String,String> getLocMap()
  	{
  		TreeMap<String,String> locMap  = new TreeMap<String,String>();
  		locMap.put("cn","China");
  		locMap.put("jp", "Japan");
  		locMap.put("sg","Singapore");
  		return locMap ;
  		
  	}
	
  	public void uploadFile(File file,Image imge) throws IOException
  	{
  		String destFileName = imge.getFullPath()+OssUtils.CLOUD_PATH_SEPARATOR+imge.getImageName();
  		OssUtils.singleUpload(BUCKET_NAME,destFileName,file);
		String url =   OssUtils.getResourceUrl(BUCKET_NAME, destFileName);
	 	imge.setImageUrl(url);
		
  		
  	}

	public void uploadFiles(File[] file,List<Image> imges) throws IOException
	{
		
		if(imges!=null && file!=null && file.length == imges.size())
		{
		
			
			for (int i = 0;i<file.length;i++)
			{
				
				uploadFile(file[i],imges.get(i));
			}
			
			
		}
		
	}
	
	

	public void deleteFile(List<Image> imges)
	{
		if(imges!=null)
		{
		
			
			for (Image img:imges)
			{
				String destFileName = img.getFullPath()+OssUtils.CLOUD_PATH_SEPARATOR+img.getImageName();
			  	
				OssUtils.delete(BUCKET_NAME, destFileName);
				
			}
			
			
		}

	
	}
}