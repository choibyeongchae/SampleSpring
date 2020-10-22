package com.spring.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.TestDao;

@Service
public class TestServiceImpl implements TestService{

	// dao 선언
	@Inject
	private TestDao dao;
	
	@Override
	public List<HashMap> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public HashMap selectUser(HashMap map) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectUser(map);
	}

	
}
