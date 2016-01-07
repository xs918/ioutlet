package sg.com.ioutlet.framework.web.common;

import java.io.File;

public class OssUtilsTest {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\daobowu\\shpg.sql");
		OssUtils.createBucket("iolt");
	    System.out.println("file name:"+file.getPath());
    //    OssUtils.singleUpload("ABC"+OssUtils.CLOUD_PATH_SEPARATOR+file.getName(), file);
    //    OssUtils.deleteBucketAndContent("iolt");
        String url = OssUtils.getPresignedUrl("ABC"+OssUtils.CLOUD_PATH_SEPARATOR+file.getName());
        String urlStr=  OssUtils.getResourceUrl("ABC"+OssUtils.CLOUD_PATH_SEPARATOR+file.getName());
        
        
         System.out.println("file     url:"+url);
         System.out.println("resource url:"+urlStr);
         

         
         
        
        
	}

}
