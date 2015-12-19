package sg.com.ioutlet.framework.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;

public class OssUtils {
	
	private static  String ACCESS_KEY_ID = "I14ejnRM6My7CyZq";
    private static String ACCESS_KEY_SECRET = "YOCIjo8nAUNC3wJ3BJfQYTlY6t7nuj";
    private static String  HOST_NAME="oss-cn-hangzhou.aliyuncs.com";
    private static String URL_HEADER="http://";
    public static String CLOUD_PATH_SEPARATOR="/";
     
    private static OSSClient client; 
    
    public static OSSClient getOSSClientInstance()
    {
    	if(client==null)
    	{
    		client= new OSSClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    	}
    	
    	return client;
    	
    }
    
    
    @SuppressWarnings("deprecation")
	public static void createBucket (String bucketName)
    {
    	if(client == null)
    	{
    		client= new OSSClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    	}
    	
    	
        if(client.doesBucketExist(bucketName))
        	return ;
    	
  
    	client.createBucket(bucketName);
    
    }
    
    public static String upload(String bucketName, String key,File file) throws FileNotFoundException {
    
    	if(client == null)
    	{
    		client= new OSSClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    	}
    	InputStream content = new FileInputStream(file);
    	ObjectMetadata meta = new ObjectMetadata();
    	meta.setContentLength(file.length());
    	
    	PutObjectResult result = client.putObject(bucketName, key, content, meta);
     	return result.getETag();
    	

    }
    
    public static String  getUrl(String bucketName, String fileFullPath)
    {
    	String url=URL_HEADER+bucketName+"."+HOST_NAME+"/"+fileFullPath;
    	return url;
    	
    }
    
    public static void  delete(String bucketName, String key)  {
    	if(client == null)
    	{
    		client= new OSSClient(ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    	}
    	client.deleteObject(bucketName, key);
    	  
    }
    
}
