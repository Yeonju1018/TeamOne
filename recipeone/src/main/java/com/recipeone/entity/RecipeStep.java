package com.recipeone.entity;

import java.io.Serializable;

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
public class RecipeStep implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "rc_num")
	private Integer stepNum;
	private String stepText;
	private String stepImg;
}
