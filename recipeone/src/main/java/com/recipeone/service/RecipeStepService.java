package com.recipeone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipeone.dto.RecipeStepDto;
import com.recipeone.entity.RecipeStep;
import com.recipeone.repository.RecipeRepository;
import com.recipeone.repository.RecipeStepRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecipeStepService {
	
	private final RecipeRepository recipeRepository;
	private final RecipeStepRepository recipeStepRepository;
	private RecipeStepDto recipeStepDto;
	
	public void saveRecipeStep(RecipeStep recipeStep) {
		recipeStep.setSteptext(recipeStep.getSteptext());
		recipeStepRepository.save(recipeStep);
	}
	
	/* public void saveRecipeStep(Long recipeId, RecipeStep recipeStep) {
	    Recipe recipe = recipeRepository.findById(recipeId)
	        .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + recipeId));
	    
	    recipeStep.setRecipe(recipe);
	    recipeStepRepository.save(recipeStep);
	}*/
	/*
	 * public List<RecipeStep> getRecipeStepsByRecipeNum(Long id) { return
	 * recipeStepRepository.findByRecipeId(id); }
	 */

}
