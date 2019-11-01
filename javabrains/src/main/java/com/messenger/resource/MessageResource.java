package com.messenger.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.messenger.model.Message;
import com.messenger.services.MessageService;

@Path("/messages")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {
	@Context UriInfo uriInfo;
	
	private static final MessageService serviceLayer = new MessageService();
	
	@GET
	public Response getMessages(){
		return Response.ok(serviceLayer.getMessages(uriInfo)).build();
	}
	
	@Path("/{id}")
	@GET	
	public Response getMessage(@PathParam("id") long messageId){
		return Response.ok(serviceLayer.getMessage(messageId,uriInfo)).build();
	}
	
	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMessage(@PathParam("id") long id, Message message ){
		return Response.ok(serviceLayer.updateMessage(id, message,uriInfo)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMesage(Message message){		
		Message newMessage =  serviceLayer.createMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		Response response = Response.created(uri).build();
		return response;
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteMessage(@PathParam("id") long messageId){
		serviceLayer.deleteMessage(messageId);
		return Response.status(Status.ACCEPTED).build();
	}
	
	@Path("/{messageId}/comments")
	public CommentResource commentsApis(){
		return new CommentResource();
	}
}
