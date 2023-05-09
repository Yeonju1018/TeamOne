package com.recipeone.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.recipeone.dto.RecipeFormDto;


public class PostController {

	@GetMapping(value = "/admin/item/new")
	public String recipeForm(Model model) {
		model.addAttribute("recipeFormDto", new RecipeFormDto());
		return "recipe/recipeForm";
	}
	
}
