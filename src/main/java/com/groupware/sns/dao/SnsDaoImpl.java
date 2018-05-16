package com.groupware.sns.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class SnsDaoImpl implements SnsDao {

	@Autowired
	private SqlMapClient client;
	
}
