package com.recipeone.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.dto.RecipeIngredientDto;
import com.recipeone.entity.Recipe;
import com.recipeone.entity.RecipeImg;
import com.recipeone.entity.RecipeIngredient;
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
	private RecipeIngredientService recipeIngredientService;

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
		for (int j=0; j<recipeImgFileList.size(); j++) {
			RecipeStep recipeStep = new RecipeStep();
			recipeStep.setRecipe(recipe);
			recipeStep.setSteptext("왜 값이 안들어갈까"+j);
			//Map<String, Object> steptext = new HashMap<String, Object>();
			//steptext.put(recipeStep.getSteptext(), j);

			recipeSteps.add(recipeStep);
			//recipeStepService.saveRecipeStep(recipeStep);
		}
		recipeStepRepository.saveAll(recipeSteps);

        return recipe.getId();
	}


	public void addIngredientToRecipe(Long recipeId, RecipeIngredientDto recipeIngredientDto) {
        Recipe recipe = getRecipeById(recipeId);

        // RecipeIngredient 생성 및 설정
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.createRecipeIngredient(recipeIngredientDto);
        recipeIngredient.setRecipe(recipe);

        // RecipeIngredient 저장
        recipeIngredientService.saveRecipeIngredient(recipeIngredient);

        // Recipe의 ingredients 리스트에 추가
        recipe.getRecipeIngredients().add(recipeIngredient);
        
     // Recipe 저장
        recipeRepository.save(recipe);
        
    }
	public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new NoSuchElementException("Recipe with ID " + recipeId + " not found"));
    }



}
