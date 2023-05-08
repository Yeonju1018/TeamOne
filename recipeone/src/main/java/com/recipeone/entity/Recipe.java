package com.recipeone.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.recipeone.dto.RecipeFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id; // 레시피 입력 아이디
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rc_num; // 레시피 게시글 번호
	
	@Column(nullable = false, length = 50)
	private String rc_title; // 레시피 제목
	
	@OneToMany
	private List<RecipeStep> rc_content; // 레시피 내용(요리순서)
	
	private String rc_cooktime; // 조리시간 (요리정보)
	private String rc_nop; // @인분 (요리정보)
	private String rc_thumbnail; // 썸네일 이미지
	
	@OneToMany
	private List<RecipeIngredient> rc_ingredient; // 레시피 재료
	private String rc_tag; // 태그
	private String rc_ctype; // 카테고리 종류별
	private String rc_csituation; // 카테고리 상황별
	private String rc_cingredient; // 카테고리 재료별
	private String rc_cmeans; // 카테고리 방법별
	private String rc_ctheme; // 카테고리 테마별
	private String rc_date; // 레시피 입력 날짜, 시간
	private String rc_count; // 레시피 조회수

	public void createRecipe(RecipeFormDto recipeFormDto) {
		this.rc_title = recipeFormDto.getRc_title();
		// 추가 필요
	}
}
