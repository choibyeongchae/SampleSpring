package com.spring.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	public List<HashMap> boardList() throws Exception;
	public int boardListCnt() throws Exception;
}
