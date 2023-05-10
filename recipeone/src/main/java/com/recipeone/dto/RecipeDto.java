package com.recipeone.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RecipeDto {
	
	private Long id;
	private String rc_title;
	private String rc_content;
	private String rc_cooktime;
	private String rc_nop; // @인분
	private String rc_thumbnail; // 썸네일 이미지
	private String rc_ingredient; // 레시피 재료
	private String rc_tag; // 태그
	private String rc_ctype; // 카테고리 종류별
	private String rc_csituation; // 카테고리 상황별
	private String rc_cingredient; // 카테고리 재료별
	private String rc_cmeans; // 카테고리 방법별
	private String rc_ctheme; // 카테고리 테마별
	
	private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
