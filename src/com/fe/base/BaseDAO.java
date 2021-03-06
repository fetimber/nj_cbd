package com.fe.base;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BaseDAO extends SqlMapClientDaoSupport
{
	 @Resource  
	 private SqlMapClient sqlMapClient;  
	 
	 @PostConstruct       
	 public void initSqlMapClient()
	 {         
		 super.setSqlMapClient(sqlMapClient);   
     } 

	 
	 
}
