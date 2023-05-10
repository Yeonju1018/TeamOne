package com.recipeone.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.entity.Recipe;
import com.recipeone.entity.RecipeImg;
import com.recipeone.repository.RecipeImgRepository;
import com.recipeone.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecipeService {
	
	private final RecipeRepository recipeRepository;
	private final RecipeImgService recipeImgService;
	private final RecipeImgRepository recipeImgRepository;
	
	public Long saveRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList) throws Exception {
		
		// 레시피 등록
		Recipe recipe = recipeFormDto.createRecipe();
		recipeRepository.save(recipe);
		
		// 이미지 등록
		for (int i=0; i< recipeImgFileList.size(); i++){
            RecipeImg recipeImg = new RecipeImg();
            recipeImg.setRecipe(recipe);;
            if (i==0){
            	recipeImg.setRepimgYn("Y");
            } else {
            	recipeImg.setRepimgYn("N");
            }
            recipeImgService.saveRecipeImg(recipeImg, recipeImgFileList.get(i));
        }
        return recipe.getId();
	}



}
