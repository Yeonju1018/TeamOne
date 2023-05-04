package com.recipeone.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name = "recipestep")
public class RecipeStep implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer num;
	private String step_text; // 설명
	private String ingredient; // 재료
	private String tool; // 도구
	private String tip; // 조리 팁
}
