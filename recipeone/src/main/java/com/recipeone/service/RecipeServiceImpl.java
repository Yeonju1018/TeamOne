package com.recipeone.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.entity.Recipe;
import com.recipeone.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	RecipeRepository recipeRepository;

	@Override
	public Long insertRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList) throws SQLException {
		recipeRepository.save(recipeFormDto,recipeImgFileList);
		
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		recipeRepository.delete(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe){
		recipeRepository.save(recipe);
		
	}

	@Override
	public List<Recipe> getRecipeList(Recipe recipe) {
		return recipeRepository.findAll();
	}

}
