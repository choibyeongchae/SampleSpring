package com.spring.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;

public class ResultSendToJson {

	public static void jsonObjectTo(HttpServletResponse response, Logger logger, JSONObject json)
	{
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
        	response.getWriter().write(json.toString());
            response.flushBuffer();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void onlyResultTo(HttpServletResponse response, Logger logger, int result)
	{
		JSONObject jsonRtnVal = new JSONObject();
        jsonRtnVal.put("result", (Object)String.valueOf(result));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        logger.info("result : " + result);
        try {
            response.getWriter().write(jsonRtnVal.toString());
            response.flushBuffer();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
