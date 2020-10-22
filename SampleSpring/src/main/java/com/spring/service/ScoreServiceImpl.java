package com.spring.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ScoreDao;
import com.spring.dao.TestDao;

@Service
public class ScoreServiceImpl implements ScoreService{

	// dao 선언
	@Inject
	private ScoreDao dao;
	
	@Override
	public List<HashMap> getScore() throws Exception {
		// TODO Auto-generated method stub
		return dao.getScore();
	}

	
}
