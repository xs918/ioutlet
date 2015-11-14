package sg.com.ioutlet.rest.service;

import javax.ws.rs.core.Response;

import sg.com.ioutlet.rest.exception.EjbUnavailableException;
import sg.com.ioutlet.rest.exception.DataNotFoundException;

public class ExceptionTest {
	public Response getExceptionTest	( String id ) throws DataNotFoundException,EjbUnavailableException
	{
		
		//validate mandatory field
		if(id == null)
			throw new DataNotFoundException("id is not present in request !!");
		
		
		if(id.equals("EJB"))
		{
			throw new EjbUnavailableException("ejb not available  !!");
		}
	

		//Validate proper format
		try
		{
			Integer.parseInt(id);
		}
		catch(NumberFormatException e)
		{
			throw new DataNotFoundException("id is not a number !!");
		}
		//Process the request
		return Response.ok().entity("User with ID " + id + " found !!").build();
	}
}
