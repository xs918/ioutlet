package sg.com.ioutlet.web.common.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

import sg.com.ioutlet.ace.user.img.Imge;
import sg.com.ioutlet.bas.Gender;
import sg.com.ioutlet.framework.web.handler.CommonActionHandler;

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
	

	public boolean uploadFiles(File[] file,List<Imge> imges)
	{
		if(imges!=null && file!=null && file.length == imges.size())
		{
		
			for (int i = 0;i<file.length;i++)
			{
				 
		   		File destFile = new File(imges.get(i).getFullPath()+File.separator+imges.get(i).getImgName());
				   
				  
					try {
				       FileUtils.copyFile(file[i], destFile);
					 } catch (IOException ex) {
					
						 for(int j=0;j<=i;j++)
						 {     
							 
					       	  try {
					       		
					       		  
					       		File deleteFile = new File(imges.get(j).getFullPath()+File.separator+imges.get(j).getImgName());
					       		  
								FileUtils.forceDelete(deleteFile);
							    } catch (IOException e) {
							
							    }
						 
						 }
		      			 return false;
					 }
					imges.get(i).setImgUrl(destFile.getAbsolutePath());
			}
			
			return true;
		}
		return false;
	
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