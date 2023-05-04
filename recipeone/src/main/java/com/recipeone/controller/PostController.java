package com.recipeone.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.recipeone.entity.Post;
import com.recipeone.entity.SmarteditorVO;
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
	
	@RequestMapping(value = "/file_uploader.jsp")
	public String simpleImageUploader(HttpServletRequest req, SmarteditorVO smarteditorVO) throws UnsupportedEncodingException {
		String callback = smarteditorVO.getCallback();
		String callback_func = smarteditorVO.getCallback_func();
		String file_result = "";
		String result = "";
		MultipartFile multiFile = smarteditorVO.getFiledata();
		try {
			if(multiFile != null && multiFile.getSize() > 0 ) {
				if(multiFile.getContentType().toLowerCase().startsWith("image/")) {
					String oriName = multiFile.getName();
					String uploadPath = req.getServletContext().getRealPath("/img");
					String path = uploadPath + "/smarteditor/";
					File file = new File(path);
					if(!file.exists()) {
						file.mkdirs();
					}
					String fileName = UUID.randomUUID().toString();
					smarteditorVO.getFiledata().transferTo(new File(path + fileName));
					file_result += "&&bNewLine=true&FileName=" + oriName + "&sFileURL=/img/smarteditor/" + fileName;
				} else {
					file_result += "&errstr=error";
				}
			} else {
				file_result += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result = "redirect:" + callback + "?callback_func=" + URLEncoder.encode(callback_func,"UTF-8") + file_result;
		return result;
	}
	

}
