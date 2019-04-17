package com.dancer.crud.service;

import com.dancer.crud.entity.Administrator;

public interface IAdministratorService {
	
	/**
	 * 根据姓名查询管理员账号
	 * @param name
	 * @return
	 */
	Administrator selectAdministrator(String name);
	
	/**
	 * md5 密码加密
	 * @param password
	 * @param uuid
	 * @return
	 */
	String EncryptedPassword(String password,String uuid);
	
	/**
	 * 注册管理员账号
	 * @param administrator
	 * @return
	 */
	String insertAdministrator(String username,String password);
	
	/**
	 * 管理员账号进行登录
	 * @param username
	 * @param password
	 * @return
	 */
	String login(String username, String password);
	
}	
