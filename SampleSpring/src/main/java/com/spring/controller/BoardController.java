package com.spring.controller;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.BoardService;
import com.spring.util.ResultSendToJson;
import com.spring.util.StringUtil;
import com.spring.viewController.ViewBoardController;
import com.spring.viewController.ViewTestController;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value ="/board",method=RequestMethod.GET)
	public ModelAndView boardGet(HttpServletRequest request,HttpServletResponse response) {

		ModelAndView model = new ModelAndView("board/board");
			
		return model;
		
	}
	
	@RequestMapping(value ="/boardList",method=RequestMethod.POST)
	@ResponseBody
	public void boardList(Model model,HttpServletRequest request,HttpServletResponse response)  {
		
	}
	
	
}
