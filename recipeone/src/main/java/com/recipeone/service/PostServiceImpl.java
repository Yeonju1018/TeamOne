package com.recipeone.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeone.entity.Post;
import com.recipeone.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;

	@Override
	public void savePost(Post post) throws SQLException {
		postRepository.save(post);
		
	}
	

}
