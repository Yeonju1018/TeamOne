package com.recipeone.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

		
}
