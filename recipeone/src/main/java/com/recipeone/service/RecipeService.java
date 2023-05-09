package com.recipeone.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.entity.Recipe;

public interface RecipeService {
	
	public Long insertRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList)  throws SQLException;
	
	public void deleteRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public List<Recipe> getRecipeList(Recipe recipe);

	
	
	//public Recipe getRecipe(Recipe recipe) throws SQLException;
}
