package com.recipeone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeone.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

}
