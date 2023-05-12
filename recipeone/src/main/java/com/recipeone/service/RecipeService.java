package com.recipeone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.entity.Recipe;
import com.recipeone.entity.RecipeImg;
import com.recipeone.entity.RecipeStep;
import com.recipeone.repository.RecipeImgRepository;
import com.recipeone.repository.RecipeRepository;
import com.recipeone.repository.RecipeStepRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecipeService {
	
	private final RecipeRepository recipeRepository;
	private final RecipeImgService recipeImgService;
	private final RecipeImgRepository recipeImgRepository;
	private final RecipeStepRepository recipeStepRepository;
	private final RecipeStepService recipeStepService;
	
	public Long saveRecipe(RecipeFormDto recipeFormDto, List<MultipartFile> recipeImgFileList) throws Exception {
		
		// 레시피 등록
		Recipe recipe = recipeFormDto.createRecipe();
		recipeRepository.save(recipe);

		// 이미지 등록
		for (int i=0; i< recipeImgFileList.size(); i++){
            RecipeImg recipeImg = new RecipeImg();
            recipeImg.setRecipe(recipe);
            
            // 대표이미지 설정
            if (i==0){
            	recipeImg.setRepimgYn("Y");
            } else {
            	recipeImg.setRepimgYn("N");
            }
            recipeImgService.saveRecipeImg(recipeImg, recipeImgFileList.get(i));
        }
		
		// 요리순서 등록
		
		List<RecipeStep> recipeSteps = new ArrayList<>();
		// String imgInfo[] = recipeSteps;
		// RecipeStep을 List 형식 말고 일반 형식으로 수정해보자
		for (int j=0; j<recipeImgFileList.size(); j++) {
			RecipeStep recipeStep = new RecipeStep();
			recipeStep.setRecipe(recipe);
			recipeStep.setSteptext("내용"+j);
			recipeSteps.add(recipeStep);
		}
		recipeStepRepository.saveAll(recipeSteps);
		
		
        return recipe.getId();
	}

}
