package com.recipeone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.recipeone.dto.RecipeFormDto;
import com.recipeone.entity.Recipe;
import com.recipeone.service.RecipeService;


@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping(value = "/admin/item/new")
	public ModelAndView insertEditor(HttpServletRequest req, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("recipe/recipePost");
		
		return mav;
	}
	
	
	
	@PostMapping("/admin/item/new")
	public String saveRecipe(@Valid RecipeFormDto recipeFormDto, BindingResult bindingResult,
			 			Model model, @RequestParam("recipeImgFile") List<MultipartFile> recipeImgFileList) {
		
		if(bindingResult.hasErrors()) {
			return "recipe/recipePost";
		}
		
		if(recipeImgFileList.get(0).isEmpty() && recipeFormDto.getId() == null) {
			model.addAttribute("errorMessage", "레시피 썸네일 이미지는 필수 입력 값 입니다.");
			return "recipe/recipePost";
		}
		
		try {
			recipeService.insertRecipe(recipeFormDto, recipeImgFileList);
		} catch (Exception e) {
			model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
			return "recipe/recipePost";
		}
		
		return "redirect:/";
	}	

}
