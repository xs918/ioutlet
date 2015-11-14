package sg.com.ioutlet.rest.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sg.com.ioutlet.rest.exception.DataNotFoundException;
import sg.com.ioutlet.rest.exception.EjbUnavailableException;
import sg.com.ioutlet.rest.service.ExceptionTest;




@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExceptionTestEndpoint 
{
	ExceptionTest usersvc = new ExceptionTest();
	@Path("/except/{id}")
	@GET
	public Response getExceptionTest	( @PathParam("id") String id ) throws DataNotFoundException, EjbUnavailableException
	{
		return usersvc.getExceptionTest(id);
	}
}