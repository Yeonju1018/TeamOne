package com.recipeone.service;

import java.sql.SQLException;

import com.recipeone.entity.Post;

public interface PostService {
	
	public void savePost(Post post) throws SQLException;
}
