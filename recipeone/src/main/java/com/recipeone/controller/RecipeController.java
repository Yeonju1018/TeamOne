package com.recipeone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.service.RecipeService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class RecipeController {
	
	private final RecipeService recipeService;
	
	/*
	 * @GetMapping(value = "/admin/item/new") public ModelAndView
	 * insertEditor(HttpServletRequest req, ModelMap model) throws Exception {
	 * ModelAndView mav = new ModelAndView("recipe/recipeForm");
	 * 
	 * return mav; }
	 */
	
	@GetMapping(value = "/admin/item/new")
	public String recipeForm(Model model) {
		model.addAttribute("recipeFormDto", new RecipeFormDto());
		return "recipe/recipeForm";
	}
	
	@PostMapping("/admin/item/new")
	public String saveRecipe(@Valid RecipeFormDto recipeFormDto, BindingResult bindingResult,
			 			Model model, @RequestParam(value="recipeImgFile") List<MultipartFile> recipeImgFileList) {
		
		if(bindingResult.hasErrors()) {
			return "recipe/recipeForm";
		}
		
		if(recipeImgFileList.get(0).isEmpty() && recipeFormDto.getId() == null) {
			model.addAttribute("errorMessage", "레시피 썸네일 이미지는 필수 입력 값 입니다.");
			return "recipe/recipeForm";
		}
		
		try {
			recipeService.saveRecipe(recipeFormDto, recipeImgFileList);
		} catch (Exception e) {
			model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
			return "recipe/recipeForm";
		}
		
		return "redirect:/";
	}	

}
