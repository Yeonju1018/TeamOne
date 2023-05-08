package com.recipeone.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.google.gson.JsonObject;
import com.recipeone.entity.Post;
import com.recipeone.service.PostService;


@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping(value = "/admin/item/new")
	public ModelAndView insertEditor(HttpServletRequest req, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("recipe/recipePost");
		
		return mav;
	}
	
	
	
	@PostMapping("/savePost")
	public View savePost(HttpServletRequest req, Post post) throws Exception {
		
		ModelMap model = new ModelMap();
		model.addAttribute("result", HttpStatus.OK);
		
		postService.savePost(post);
		
		return new MappingJackson2JsonView();
	}	

}
