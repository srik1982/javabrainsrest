package com.messenger.auth;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;


public class AuthenticationFilter implements ContainerRequestFilter{

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		MultivaluedMap<String,String> map = requestContext.getHeaders();
		if(map.containsKey("Authorization")){
			List<String> values = map.get("Authorization");
			String value = values.get(0);
			value = value.replace("Basic ", "");
			byte[] bytes = Base64.getDecoder().decode(value);
			String str = new String(bytes);
			String user = str.split(":")[0];
			String pass = str.split(":")[1];
			
			if(user.equals("user") && pass.equals("password")){
				return;
			}
		}
		
		requestContext.abortWith(Response.ok(new AuthMessage("Not Access", "Please check your username and password")).status(Status.UNAUTHORIZED).build());
	}

}
