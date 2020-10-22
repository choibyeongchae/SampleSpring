package com.spring.viewController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.spring.service.TestService;
import com.spring.service.TestServiceImpl;

public class ViewScoreController {
	
	
	public JSONObject getScore(List<HashMap> list) throws Exception {
		JSONObject obj = new JSONObject();
		JSONArray jsonArr = new JSONArray(list);
		
		obj.put("list", jsonArr);
		
		return obj;
	}
}