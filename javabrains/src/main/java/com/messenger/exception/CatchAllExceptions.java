package com.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CatchAllExceptions implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		MyException e = new MyException();
		e.description = "This is a catch all, i don't know what went wrong and where it went wrong. Go to the console and see for yourself.";
		e.exceptionCode = 007;
		e.message = "You are using a pathetic product. so deal with this.";
		return Response.ok(e).status(Status.BAD_REQUEST).build();
	}

}
