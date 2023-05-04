package com.recipeone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "post")
public class Post extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long postNo;
	
	@Column
	private String title;
	@Column
	private String content;
}
