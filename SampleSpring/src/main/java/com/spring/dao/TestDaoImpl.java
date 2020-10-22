package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao{

	// sql접근을 위한 객체
	@Inject
	private SqlSession sqlsession;
	
	// mapper파일의 namespace
	private static String namespace = "com.spring.mapper.TestMapper";

	@Override
	public List<HashMap> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".selectTest");
	}

	@Override
	public HashMap selectUser(HashMap map) throws Exception {
		// TODO Auto-generated method stub
		HashMap rtnVal = sqlsession.selectOne(namespace+".selectUser",(Object) map);
		return rtnVal;
	}

	
}
