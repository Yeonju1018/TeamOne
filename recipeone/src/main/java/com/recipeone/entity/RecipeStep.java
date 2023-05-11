package com.recipeone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.recipeone.dto.RecipeStepDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name = "recipeStep")
public class RecipeStep extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity = Recipe.class, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "num")
	private Recipe recipe; // 레시피 번호
	private String stepText; // 레시피 설명 (조리 설명)
	private String stepImg; // 레시피 이미지 (조리 이미지)
	
	public void createRecipeStep(RecipeStepDto recipeStepDto) {
		this.id = recipeStepDto.getId();
		this.recipe = recipeStepDto.getRecipe();
		this.stepText = recipeStepDto.getStepText();
		this.stepImg = recipeStepDto.getStepImg();
	}
}
