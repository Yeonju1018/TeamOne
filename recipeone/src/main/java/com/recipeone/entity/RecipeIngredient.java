package com.recipeone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.recipeone.dto.RecipeIngredientDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name = "recipeIgredient")
public class RecipeIngredient extends BaseTimeEntity {

	@Id
	private Long id;
	
	@ManyToOne(targetEntity = Recipe.class)
	@JoinColumn(name = "num")
	private Recipe recipe; // 재료번호
	
	private String gubun; // 큰 구분
	private String igdName; // 재료이름
	private String count; // 중량, 수량
	
	public void createRecipeIngredient(RecipeIngredientDto recipeIngredientDto) {
		this.id = recipeIngredientDto.getId();
		this.recipe = recipeIngredientDto.getRecipe();
		this.gubun = recipeIngredientDto.getGubun();
		this.igdName = recipeIngredientDto.getIgdName();
		this.count = recipeIngredientDto.getCount();
	}
}
