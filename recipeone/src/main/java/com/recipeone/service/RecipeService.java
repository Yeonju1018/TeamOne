package com.recipeone.service;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.dto.RecipeIngredientDto;
import com.recipeone.entity.Recipe;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RecipeService {

    List<String> recommendKeywords(String keyword) throws RecipeIdExistException;

    static class RecipeIdExistException extends Exception { }

    static class RecipeExistException extends Exception { }

    List<Long> searched(String keyword) throws RecipeIdExistException;

    public Long saveRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList) throws Exception;

    public void addIngredientToRecipe(Long recipeId, RecipeIngredientDto recipeIngredientDto);

    public Recipe getRecipeById(Long recipeId);

    public List<Long> filterSearchedId(List<String> recommendedKeywords, String rctype, String rcsituation, String rcmeans, String rcingredient) throws RecipeIdExistException;

    public List<Recipe> filterSearchedRecipe(List<String> recommendedKeywords, String rctype, String rcsituation, String rcmeans, String rcingredient,  Model model) throws RecipeExistException;

}