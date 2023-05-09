package com.recipeone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name = "recipeStep")
public class RecipeStep extends BaseTime {
	
	@Id
	private Long user_id;
	
	@ManyToOne(targetEntity = Recipe.class)
	@JoinColumn(name = "rc_num")
	private Recipe recipe; // 레시피 번호
	private String stepText; // 레시피 설명 (조리 설명)
	private String stepImg; // 레시피 이미지 (조리 이미지)
}
