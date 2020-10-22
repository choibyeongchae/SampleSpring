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

import com.spring.service.TestService;
import com.spring.util.ResultSendToJson;
import com.spring.viewController.ViewTestController;

@Controller
// test폴더 매핑
@RequestMapping("/test/*")
public class TestController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TestController.class);

	@Inject
	private TestService service;
	
	// test폴더안의 test.jsp를 지칭
	@RequestMapping(value ="/test",method=RequestMethod.GET)
	public ModelAndView testGet(HttpServletRequest request,HttpServletResponse response) {

		ModelAndView model = new ModelAndView("test/test");
			
		return model;
		
	}
	
	@RequestMapping(value ="/testPost",method=RequestMethod.POST)
	@ResponseBody
	public void testPost(Model model,HttpServletRequest request,HttpServletResponse response) {
		StringBuilder str = new StringBuilder();
		try {
			
			ViewTestController viewController = new ViewTestController();
			List<HashMap> list = service.list();
			JSONObject obj = viewController.getMember(list);
			JSONArray jsonArr = obj.getJSONArray("list");
			
			for (int i = 0; i < jsonArr.length(); i++) {
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				
				String reg_date = String.valueOf(jsonObj.get("reg_date"));
				reg_date = reg_date.substring(0, reg_date.indexOf("."));
				
				str.append("<tr>");
				str.append("<td>"+String.valueOf(jsonObj.get("user_id"))+"</td>");
				str.append("<td>"+String.valueOf(jsonObj.get("user_email"))+"</td>");
				str.append("<td>"+reg_date+"</td>");
				str.append("</tr>");
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JSONObject jsonRtn = new JSONObject();
			jsonRtn.put("list",str);
			ResultSendToJson.jsonObjectTo(response, logger, jsonRtn);
		}
		
	}
	
	@RequestMapping(value ="/searchUser",method=RequestMethod.POST)
	@ResponseBody
	public void searchUser(Model model,HttpServletRequest request,HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		StringBuilder str = new StringBuilder();
		try {
			ViewTestController viewTestController = new ViewTestController();
			jsonObj = viewTestController.searchMember(service,request);
			if (jsonObj.has("result")) {
				str.append("null");
			} else {
				String reg_date = String.valueOf(jsonObj.get("reg_date"));
				reg_date = reg_date.substring(0, reg_date.indexOf("."));
				str.append("<tr>");
				str.append("<td>"+String.valueOf(jsonObj.get("user_id"))+"</td>");
				str.append("<td>"+String.valueOf(jsonObj.get("user_email"))+"</td>");
				str.append("<td>"+reg_date+"</td>");
				str.append("</tr>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JSONObject jsonRtn = new JSONObject();
			jsonRtn.put("result",str);
			ResultSendToJson.jsonObjectTo(response, logger, jsonRtn);
		}
	}
}
