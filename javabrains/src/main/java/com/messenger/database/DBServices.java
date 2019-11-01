package com.messenger.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;

import com.messenger.model.Comment;
import com.messenger.model.Message;
import com.messenger.model.Profile;

public class DBServices {
	Map<Long, Message> messages = new HashMap<Long, Message>();
	Map<Long, Map<Long, Comment>> comments = new HashMap<Long, Map<Long, Comment>>();
	Map<Long, Profile> profiles = new HashMap<Long, Profile>();
	
	@SuppressWarnings("unchecked")
	public List<Message> getMessages(){
		if(messages.isEmpty()){
			Message m = new Message(1,"message 1", "srikanth");
			messages.put(1L, m);
			
			m = new Message(2L,"message 2", "shailaja");
			messages.put(2L, m);
			
			m = new Message(3L,"message 3", "anarghya");
			messages.put(3L, m);
		}
		return (List<Message>)new ArrayList(messages.values());
	}
	
	public Message getMessage(long messageId){
		return messages.get(messageId);
	}
	
	public void deleteMessage(long messageId){
		messages.remove(messageId);
	}
	
	public Message updateMessage(long messageId, Message message){
		message.setId(messageId);
		messages.put(messageId, message);
		return message;
	}
	
	public Message createMessage(Message message){
		messages.put(message.getId(), message);
		return message;
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> getProfiles(){
		return (List<Message>)new ArrayList(profiles.values());
	}
	
	public Profile getProfile(long profileId){
		return profiles.get(profileId);
	}
	
	public void deleteProfile(long profileId){
		profiles.remove(profileId);
	}
	
	public Profile updateProfile(long profileId, Profile profile){
		profile.setId(profileId);
		profiles.put(profileId, profile);
		return profile;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getComments(long messageId){
		Map<Long,Comment> _comments = comments.get(messageId);
		if(comments!=null && !_comments.isEmpty())
			return (List<Comment>)new ArrayList(_comments.values());
		else
			return null;
	}
	
	public Comment getComment(long messageId, long commentId){
		Map<Long,Comment> _comments = comments.get(messageId);
		return _comments.get(commentId);
	}
	
	public void deleteComment(long messageId, long commentId){
		Map<Long,Comment> _comments = comments.get(messageId);
		_comments.remove(commentId);
	}
	
	public Comment updateComment(long messageId, long commentId, Comment comment){
		comment.setId(commentId);
		Map<Long,Comment> _comments = comments.get(messageId);
		_comments.put(commentId, comment);
		return comment;
	}
	public Comment createComment(long messageId, long commentId, Comment comment){
		comment.setId(commentId);
		Map<Long,Comment> _comments = comments.get(messageId);
//		if(_comments == null){
//			_comments = new HashMap<Long,Comment>();
//			comments.put(messageId,_comments);
//		}
		if(_comments == null){
			throw new IllegalArgumentException();
		}
		_comments.put(commentId, comment);
		return comment;
	}
}
