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

public class ViewTestController {
	
	
	public JSONObject getMember(List<HashMap> list) throws Exception {
		JSONObject obj = new JSONObject();
		JSONArray jsonArr = new JSONArray(list);
		
		obj.put("list", jsonArr);
		
		return obj;
	}
	
	public JSONObject searchMember(TestService service,HttpServletRequest request) throws Exception {
		
		HashMap map = new HashMap();
		map.put("user_id", String.valueOf(request.getParameter("user_id")));
		map = service.selectUser(map);
		
		JSONObject obj = null;
		
		if (map == null) {
			HashMap resultMap = new HashMap();
			resultMap.put("result", "null");
			obj = new JSONObject(resultMap);
		} else {
			obj = new JSONObject(map);
		}
		
		return obj;	
		
	}
}
