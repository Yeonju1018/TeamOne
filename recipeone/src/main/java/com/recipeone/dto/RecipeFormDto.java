package com.recipeone.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

// 나중에 
@Getter @Setter
public class RecipeFormDto {
	
	private Long id; // 레시피 입력 아이디
	
	private Integer rc_num; // 레시피 게시글 번호
	
	@NotBlank(message = "제목은 필수!")
	private String rc_title; // 레시피 제목
	
	@NotBlank(message = "내용은 필수!")
	private String rc_content; // 레시피 내용
	private String rc_cooktime; // 조리시간
	private String rc_nop; // @인분
	private String rc_thumbnail; // 썸네일 이미지
	
	@NotBlank(message = "재료는 필수!")
	private String rc_ingredient; // 레시피 재료
	private String rc_tag; // 태그
	private String rc_ctype; // 카테고리 종류별
	private String rc_csituation; // 카테고리 상황별
	private String rc_cingredient; // 카테고리 재료별
	private String rc_cmeans; // 카테고리 방법별
	private String rc_ctheme; // 카테고리 테마별
}
