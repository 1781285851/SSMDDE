package com.dancer.crud.dao;

import org.springframework.stereotype.Repository;

import com.dancer.crud.entity.Administrator;

@Repository
public interface AdministratorMapperDao {
	
	/**
	 * 注册管理员（增加管理员账号）
	 * @param administrator
	 * @return
	 */
	int insert(Administrator administrator);
	
	/**
	 * 查询管理员信息
	 * @param name
	 * @return
	 */
	Administrator selectName(String name);
	
}