package com.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NPEMapper implements ExceptionMapper<NullPointerException> {

	
	@Override
	public Response toResponse(NullPointerException exception) {
		MyException ex = new MyException(500, "Something went wrong", "i dont really care what went wrong. You come debug and find out");
		return Response.ok(ex).status(Status.BAD_REQUEST).build();
	}

}
