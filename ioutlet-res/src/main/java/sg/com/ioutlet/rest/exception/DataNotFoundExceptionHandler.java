package sg.com.ioutlet.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class DataNotFoundExceptionHandler implements
		ExceptionMapper<DataNotFoundException> {

	public Response toResponse(DataNotFoundException ex) {


		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 400, "http://javabrains.koushik.org");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		
		
		
	}
}
