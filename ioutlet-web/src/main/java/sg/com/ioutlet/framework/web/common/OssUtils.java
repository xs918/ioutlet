package sg.com.ioutlet.framework.web.common;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sg.com.ioutlet.exception.BusinessException;

import com.amazonaws.AmazonClientException;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;


public class OssUtils {
	

    public static String CLOUD_PATH_SEPARATOR="/";
    public static final String  DEFAULT_BUCKET_NAME = "iolt";
    
     
    private static AmazonS3Client  s3Client ; 
    
    
    
    public static AmazonS3Client getS3ClientInstance()
    {
    	if(s3Client==null)
    	{
    		
    		
    		s3Client= new AmazonS3Client( new ProfileCredentialsProvider());
    		s3Client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_1));

    	}
    	 
    	return s3Client;
    	
    }
    
    
 
	public static void createBucket (String bucketName)
    {
    	if(s3Client == null)
    	{
    		s3Client= getS3ClientInstance();
    	}
    	
    	
        if(!s3Client.doesBucketExist(bucketName))
        		s3Client.createBucket(new CreateBucketRequest(
						bucketName));
        
     
    }
    
	
	public static void  deleteBucketAndContent (String bucketName)
	{
		if(s3Client == null)
    	{
    		s3Client= getS3ClientInstance();
    	}
    	
		 ObjectListing objectListing = s3Client.listObjects(bucketName);
		 while (true) {
             for ( Iterator<?> iterator = objectListing.getObjectSummaries().iterator(); iterator.hasNext(); ) {
                 S3ObjectSummary objectSummary = (S3ObjectSummary) iterator.next();
                 s3Client.deleteObject(bucketName, objectSummary.getKey());
             }
  
             if (objectListing.isTruncated()) {
                 objectListing = s3Client.listNextBatchOfObjects(objectListing);
             } else {
                 break;
             }
         };


		
	}
	
	public static S3Object getObject(String bucketName,String Key)
	{
		if(s3Client == null)
    	{
    		s3Client= getS3ClientInstance();
    	}
		
		GetObjectRequest getRequest = new GetObjectRequest(bucketName,Key);
		S3Object s3object  = s3Client.getObject(getRequest);
		
		  
		return s3object;
		
	}
	
	public static String getPresignedUrl(String key)
	{
		return getPresignedUrl(DEFAULT_BUCKET_NAME,key);
	}
	
	
	public static String getResourceUrl(String bucketName,  String key)
	{
		return s3Client.getResourceUrl(bucketName, key);
	}
	
	public static String getResourceUrl( String key)
	{
		return s3Client.getResourceUrl(DEFAULT_BUCKET_NAME, key);
	}
	
	
	public static String getPresignedUrl(String bucketName,String key)
	{
		
		
		
			if(s3Client == null)
	    	{
				s3Client= getS3ClientInstance();
	    	}
			
			java.util.Date expiration = new java.util.Date();
			long milliSeconds = expiration.getTime();
			milliSeconds += 1000 * 60 * 60*24; // Add 1 hour.
			expiration.setTime(milliSeconds);

			
			
			
			GeneratePresignedUrlRequest generatePresignedUrlRequest =   new GeneratePresignedUrlRequest(bucketName, key);
			generatePresignedUrlRequest.setMethod(HttpMethod.GET); 
			generatePresignedUrlRequest.setExpiration(expiration);
			

			URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
			
			
			if(url!=null)
			{
				return  url.toString();
			}
			return null;
   
		
		
	}
	/*
	 * 
	 * 
	public static  int uploadObject(String bucketName, String key ) throws IOException
	{
		java.util.Date expiration = new java.util.Date();
		long milliSeconds = expiration.getTime();
		milliSeconds += 1000 * 60 * 60; // Add 1 hour.
		expiration.setTime(milliSeconds);

		GeneratePresignedUrlRequest generatePresignedUrlRequest = 
			    new GeneratePresignedUrlRequest(bucketName, key);
		generatePresignedUrlRequest.setMethod(HttpMethod.PUT); 
		generatePresignedUrlRequest.setExpiration(expiration);

		URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest); 

		return uploadObject(url);

	}
	
	public static int uploadObject(URL url) throws IOException
	{
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream());
		out.write("This text uploaded as object.");
		out.close();
		int responseCode = connection.getResponseCode();
	    return responseCode;

	}
	*/
	
	
	
	
    public static void singleUpload(String bucketName, String key,File file)  {
		if(s3Client == null)
    	{
			s3Client= getS3ClientInstance();
    	}
		PutObjectRequest  putObject = new PutObjectRequest(bucketName, key, file);
		s3Client.putObject(putObject);
		
    }
    
    
    public static void singleUpload(String key,File file)  {
    	singleUpload(DEFAULT_BUCKET_NAME,key,file);
    }
    
    
    public static void  multiPartUploadH(String bucketName,String key,File file) 
    {
    	 TransferManager tm = new TransferManager(new ProfileCredentialsProvider());    
    	 Upload upload = tm.upload(bucketName, key,file);
    	 try {
         		upload.waitForCompletion();
		 } catch (AmazonClientException amazonClientException) {
         throw  new BusinessException(amazonClientException);
         } catch (InterruptedException e) {
		   throw new BusinessException(e);
		}
      	 
    }
    
    public static void  multiPartUploadH(String key,File file) 
    {
    	multiPartUploadH(DEFAULT_BUCKET_NAME,key,file);
    }
    

    
    public static void  multiPartUploadL(String bucketName,String key,File file) 
    {
      	if(s3Client == null)
    	{
			s3Client= getS3ClientInstance();
    	}
    	
      	List<PartETag> partETags = new ArrayList<PartETag>();
    
       
    	 // Step 1: Initialize.
        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(bucketName, key);
        InitiateMultipartUploadResult initResponse =   s3Client.initiateMultipartUpload(initRequest);
    	long contentLength = file.length();
    	long partSize = 5 * 1024 * 1024; // Set part size to 5 MB.
    	long filePosition = 0;
    	for (int i = 1; filePosition < contentLength; i++) {
    		partSize = Math.min(partSize, (contentLength - filePosition));
    		// Create request to upload a part.
            UploadPartRequest uploadRequest = new UploadPartRequest()
                .withBucketName(bucketName).withKey(key)
                .withUploadId(initResponse.getUploadId()).withPartNumber(i)
                .withFileOffset(filePosition)
                .withFile(file)
                .withPartSize(partSize);
            
            partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());

            filePosition += partSize;
            
            
            
    	}
    	CompleteMultipartUploadRequest compRequest = new CompleteMultipartUploadRequest( bucketName, key,initResponse.getUploadId(), partETags);
        s3Client.completeMultipartUpload(compRequest);
    
      	 
    }
    
    
    public static void  multiPartUploadL(String key,File file)
    {
    	multiPartUploadL(DEFAULT_BUCKET_NAME,key,file);
    }
    
    
    
    public static void  delete(String bucketName, String key)  {
    	if(s3Client == null)
    	{
    		s3Client= getS3ClientInstance();
    	}
    	s3Client.deleteObject(new DeleteObjectRequest(bucketName,key));
    	  
    }
    
    
    public static void  delete(String key)  {
    	delete(DEFAULT_BUCKET_NAME,key);
    }
    
    
}
