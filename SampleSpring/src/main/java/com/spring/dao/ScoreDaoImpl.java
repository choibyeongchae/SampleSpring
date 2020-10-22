package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.viewController.ViewTestController;

@Repository
public class ScoreDaoImpl implements ScoreDao{

	// sql접근을 위한 객체
	@Autowired
	private SqlSession sqlsession;
	
	// mapper파일의 namespace
	private static String namespace = "com.spring.mapper.ScoreMapper";

	@Override
	public List<HashMap> getScore() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".getScore");
	}
	
}
