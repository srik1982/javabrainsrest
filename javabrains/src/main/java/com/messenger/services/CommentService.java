package com.messenger.services;

import java.util.List;

import com.messenger.database.DBServices;
import com.messenger.model.Comment;
import com.messenger.model.Comments;

public class CommentService {
	
	DBServices dbLayer = new DBServices();
	int count = 1;

	public Comments getAllComments(long messageId) {
		// TODO Auto-generated method stub
		List<Comment> allComments = dbLayer.getComments(messageId);
		Comments comments = new Comments();
		comments.setComments(allComments);
		return comments;
	}

	public Comment addComment(long messageId, Comment comment) {
		Comment _comment = dbLayer.createComment(messageId, count++, comment);
		return _comment;
	}

	public Comment updateComment(long messageId, long commentId, Comment comment) {
		Comment _comment = dbLayer.updateComment(messageId, commentId, comment);
		return _comment;
	}

	public void removeComment(long messageId, long commentId) {
		dbLayer.deleteComment(messageId, commentId);	
	}
	
	public Comment getComment(long messageId, long commentId){
		return dbLayer.getComment(messageId, commentId);
	}

}
