package sg.com.ioutlet.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class DataNotAcceptableExceptionHandler implements
		ExceptionMapper<DataNotAcceptableException> {

	public Response toResponse(DataNotAcceptableException ex) {


		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 406, "http://www.ioutlet.com/help");
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(errorMessage)
				.build();
		
		
		
	}

}
