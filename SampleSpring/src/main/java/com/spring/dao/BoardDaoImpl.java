package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession sqlsession;
	
	// mapper파일의 namespace
	private static String namespace = "com.spring.mapper.BoardMapper";
	
	@Override
	public List<HashMap> boardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".getBoardList");
	}

	@Override
	public int boardTotalCnt() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".getBoardCount");
	}
	
	
}
