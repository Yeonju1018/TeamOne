package com.recipeone.service;
import com.recipeone.entity.Pagination;
import com.recipeone.entity.Recipe;
import com.recipeone.entity.RecipeIngredient;
import com.recipeone.entity.RecipeStep;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

//@Service
public interface RecipeService {
    //추가
    List<String> recommendKeywords(String keyword) throws RecipeIdExistException;
    //    아래는 되는 기본코드
    static class RecipeIdExistException extends Exception{
    }
    List<Integer> searched(String keyword) throws RecipeIdExistException;

    public int registRecipe(Recipe recipe);

	public int registStep(List<RecipeStep> rsList);

	public int registIngredient(List<RecipeIngredient> rmList) ;
	
	public int checkRecommand(int recipeno, String memberEmail);

	public int allRecipeCommentList(int page, int limit, int recipeno);

	public int modifyOneRecipe(Recipe recipe) ;

	public int modifyOneRecipeStep(List<RecipeStep> rsList) ;

	public int  modifyOneRecipeIngredient(List<RecipeIngredient> rmList);

	public int removeOneRecipe(int recipeno);

	public List<Recipe> printRecipeList(Pagination pagination);

	public Recipe printOneRecipe(int recipeno) ;
	public List<RecipeStep> printOneRecipeStep(int recipeno) ;
	
	public List<RecipeIngredient> printOneRecipeIngredient(int recipeno) ;
	
	public int removeOneImg(String picName);

	public List<Recipe> recomadRecipe(String recipeCategory);

	public int getTotalCount(int recipeno);

	public String printMemberName(String useremail);

	public int checkMyRecipe(int recipeno, String useremail);

	public String getMemberEmail(int recipeno);
	

    static class RecipeExistException extends Exception { }

    public List<Recipe> filterSearchedRecipe(List<String> recommendedKeywords, String rctype, String rcsituation, String rcmeans, String rcingredient,  Model model) throws RecipeExistException;

	public int totalRecord();
}
