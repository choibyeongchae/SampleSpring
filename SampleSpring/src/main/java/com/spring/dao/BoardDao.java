package com.spring.dao;

import java.util.HashMap;
import java.util.List;

public interface BoardDao {
	public List<HashMap> boardList() throws Exception;
	public int boardTotalCnt() throws Exception;
}
