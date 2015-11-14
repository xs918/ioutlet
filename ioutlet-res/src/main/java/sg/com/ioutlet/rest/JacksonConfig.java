package sg.com.ioutlet.rest;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import sg.com.ioutlet.vo.utils.VoUtils;


@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {
	private final ObjectMapper objectMapper;
	
	
	 public JacksonConfig()
	    {
	        objectMapper = new ObjectMapper();
	        this.objectMapper.setDateFormat(new SimpleDateFormat(VoUtils.DEFAULT_DATE_FORMATING));  
	        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	    }
	
	  @Override
	public ObjectMapper getContext(Class<?> type) {
		// TODO Auto-generated method stub
		return objectMapper;
	}


	 }