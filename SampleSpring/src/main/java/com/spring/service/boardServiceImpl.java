package com.spring.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.BoardDao;

@Service
public class boardServiceImpl implements BoardService{

	@Inject
	private BoardDao dao;
	
	@Override
	public List<HashMap> boardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.boardList();
	}

	@Override
	public int boardListCnt() throws Exception {
		// TODO Auto-generated method stub
		return dao.boardTotalCnt();
	}
	
}
