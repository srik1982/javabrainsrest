package com.messenger.services;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import com.messenger.database.DBServices;
import com.messenger.model.Message;
import com.messenger.model.Messages;

public class MessageService {
	DBServices dbLayer = new DBServices();
	long count = 1;
	
	public Messages getMessages(UriInfo uriInfo){
		Messages messages = new Messages();
		messages.setMessages(dbLayer.getMessages());
		List<Message> _msgs = messages.getMessages();
		for(Message _m : _msgs){
			_m.addLink(uriInfo.getAbsolutePathBuilder().path(Long.toString(_m.getId())).build().toString(), "self");
		}
		return messages;
	}
	
	public Message getMessage(long messageId,UriInfo uriInfo){
		Message m = dbLayer.getMessage(messageId);
		m.addLink(uriInfo.getAbsolutePathBuilder().path(Long.toString(m.getId())).build().toString(), "self");
		return m;
	}
	
	public Message createMessage(Message message){
		message.setId(count++);
		return dbLayer.createMessage(message);
	}
	
	public void deleteMessage(long messageId){
		dbLayer.deleteMessage(messageId);
	}
	
	public Message updateMessage(long messageId, Message message,UriInfo uriInfo){
		Message m = dbLayer.updateMessage(messageId, message);
		m.addLink(uriInfo.getAbsolutePathBuilder().path(Long.toString(m.getId())).build().toString(), "self");
		return m;
	}
}
