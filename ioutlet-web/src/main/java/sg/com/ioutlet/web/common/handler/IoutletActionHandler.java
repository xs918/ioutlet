package sg.com.ioutlet.web.common.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

import sg.com.ioutlet.bas.Gender;
import sg.com.ioutlet.framework.web.common.AliOssUtils;
import sg.com.ioutlet.framework.web.handler.CommonActionHandler;
import sg.com.ioutlet.model.img.Imge;

import com.opensymphony.xwork2.ActionSupport;

public class IoutletActionHandler  extends CommonActionHandler  {
	
	

	

	public IoutletActionHandler(ActionSupport action) {
		super(action);
	
	}

	
	public Map<String,String> getGenderMap()
  	{
  		Map<String,String> genderMap  = new TreeMap<String,String>();
  		genderMap.put(Gender.F.name(), Gender.F.toString());
  		genderMap.put(Gender.M.name(), Gender.M.toString());
  		genderMap.put(Gender.O.name(), Gender.O.toString());
  		return genderMap;
  		
  	}
	
  	public Map<String,String> getLangMap()
  	{
  		Map<String,String> langMap  = new TreeMap<String,String>();
  		langMap.put("cn","Chinese");
  		langMap.put("jp", "Japanese");
  		langMap.put("en","English");
  		return langMap;
  		
  	}
	
  	
  	public Map<String,String> getLocMap()
  	{
  		Map<String,String> locMap  = new TreeMap<String,String>();
  		locMap.put("cn","China");
  		locMap.put("jp", "Japan");
  		locMap.put("sg","Singapore");
  		return locMap ;
  		
  	}
	
  	public void uploadFile(File file,Imge imge) throws IOException
  	{
  		String destFileName = imge.getFullPath()+File.separator+imge.getImgName();
  		File destFile = new File(destFileName);
  		String url =   AliOssUtils.getUrl(BUCKET_NAME, destFileName);
  		FileUtils.copyFile(file, destFile);
		AliOssUtils.uploadImge(BUCKET_NAME,destFileName,file);
		imge.setImgUrl(url);
		
  		
  	}

	public void uploadFiles(File[] file,List<Imge> imges) throws IOException
	{
		
		if(imges!=null && file!=null && file.length == imges.size())
		{
		
			
			for (int i = 0;i<file.length;i++)
			{
				
				uploadFile(file[i],imges.get(i));
			}
			
			
		}
		
	}
	
	
	void removeFile(File file)
	{
		File parentFile = file.getParentFile();
	
		try {
			FileUtils.forceDelete(file);
			if(parentFile.isDirectory())
			{
				if(parentFile.listFiles().length == 0)
				{
					removeFile(parentFile);
				}
				
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteFile(List<Imge> imges)
	{
		
		if(imges !=null)
		{
			for(Imge img:imges)
			{
				File deleteFile= new File(img.getFullPath()+File.separator+img.getImgName());
				removeFile(deleteFile);
			
			}
		}
	}
}