package com.dancer.crud.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.dancer.crud.dao.AdministratorMapperDao;
import com.dancer.crud.entity.Administrator;

@Service
public class AdministratorService implements IAdministratorService{
	
	@Autowired
	AdministratorMapperDao administratorMapperDao;
	
	@Autowired
	Administrator administrator;
	
	/**
	 * ����������ѯ����Ա�˺�
	 */
	@Override
	public Administrator selectAdministrator(String name) {
		//����������ѯ�Ƿ�Ϊ��
		Administrator administrator = administratorMapperDao.selectName(name);
		return administrator;
	}
	
	/**
	 * md5 �������
	 */
	@Override
	public String EncryptedPassword(String password, String uuid) {
		//���������������Σ�ƴ������
		String str = password+uuid;
		//��ȡƴ�Ӻ���ַ�������ϢժҪ�����ܺ�����룩
		String md5 = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		return md5;
	}
	
	/**
	 * ע�����Ա�˺�
	 */
	@Override
	public String insertAdministrator(String username,String password) {
		//����������ѯ����Ա�˺�
		Administrator administrator1 = selectAdministrator(username);
		//Administrator administrator1 = new Administrator();
		if(null == administrator1){
			//���ɵ������
			String salt = UUID.randomUUID().toString().toUpperCase();
			//����md5����
			String md5password = EncryptedPassword(password,salt);
			//����ʱ��
			Date date=new Date();
			administrator.settName(username);
			administrator.settUuid(salt);
			administrator.settPassword(md5password);
			administrator.settCreatetime(date);
			int num = administratorMapperDao.insert(administrator);
			System.out.println("�˺�ע��ɹ�");
			return "succeed";
		}else {
			System.out.println("���˺��Ѿ�����");
			return "failed";
		}
	}
	
	/**
	 * ����Ա�˺Ž��е�¼
	 */
	@Override
	public String login(String username, String password) {
		//����������ѯ����Ա�˺�
		Administrator administrator = selectAdministrator(username);
		if(null != administrator){
			String uuid = administrator.gettUuid();
			String databasePassword = administrator.gettPassword();
			String md5password = EncryptedPassword(password,uuid);
			if(databasePassword.equals(md5password)){
				//System.out.println("��½�ɹ�");
				return "succeed";
			}else {
				//System.out.println("�˺Ż�������ʧ��");
				return "failed";
			}
		}else {
			return "failed";
		}
		
	}
	
}
