package com.dancer.crud.service;

import com.dancer.crud.entity.Administrator;

public interface IAdministratorService {
	
	/**
	 * ����������ѯ����Ա�˺�
	 * @param name
	 * @return
	 */
	Administrator selectAdministrator(String name);
	
	/**
	 * md5 �������
	 * @param password
	 * @param uuid
	 * @return
	 */
	String EncryptedPassword(String password,String uuid);
	
	/**
	 * ע�����Ա�˺�
	 * @param administrator
	 * @return
	 */
	String insertAdministrator(String username,String password);
	
	/**
	 * ����Ա�˺Ž��е�¼
	 * @param username
	 * @param password
	 * @return
	 */
	String login(String username, String password);
	
}	
