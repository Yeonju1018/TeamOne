package com.recipeone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
@Entity
@Table(name = "recipeIgredient")
public class RecipeIngredient {

	@Id
	@ManyToOne
	@JoinColumn(name = "rc_num")
	private Integer igdNum; // 재료번호
	private String title; // 큰 구분
	private String igdName; // 재료이름
	private String count; // 중량, 수량
}
