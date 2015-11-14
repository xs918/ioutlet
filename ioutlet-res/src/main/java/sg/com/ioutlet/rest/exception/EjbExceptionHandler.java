package sg.com.ioutlet.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class EjbExceptionHandler implements ExceptionMapper<EjbUnavailableException> 
	 {

	public Response toResponse(EjbUnavailableException ex) {


		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://www.ioutlet.com/help");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
		
		
		
	}
}
