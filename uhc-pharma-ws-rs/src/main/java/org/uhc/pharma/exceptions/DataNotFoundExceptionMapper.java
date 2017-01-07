package org.uhc.pharma.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider 
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	
	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage error = new ErrorMessage(exception.getMessage(), "404", "www.uhc.com");
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
