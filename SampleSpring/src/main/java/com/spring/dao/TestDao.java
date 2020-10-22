package com.spring.dao;

import java.util.HashMap;
import java.util.List;

public interface TestDao {
	public List<HashMap> list() throws Exception;
	
	public HashMap selectUser(HashMap map) throws Exception;
}
