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
	 * 根据姓名查询管理员账号
	 */
	@Override
	public Administrator selectAdministrator(String name) {
		//根据姓名查询是否为空
		Administrator administrator = administratorMapperDao.selectName(name);
		return administrator;
	}
	
	/**
	 * md5 密码加密
	 */
	@Override
	public String EncryptedPassword(String password, String uuid) {
		//把密码和随机数（盐）拼接起来
		String str = password+uuid;
		//获取拼接后的字符串的消息摘要（加密后的密码）
		String md5 = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		return md5;
	}
	
	/**
	 * 注册管理员账号
	 */
	@Override
	public String insertAdministrator(String username,String password) {
		//根据姓名查询管理员账号
		Administrator administrator1 = selectAdministrator(username);
		//Administrator administrator1 = new Administrator();
		if(null == administrator1){
			//生成的随机数
			String salt = UUID.randomUUID().toString().toUpperCase();
			//进行md5加密
			String md5password = EncryptedPassword(password,salt);
			//创建时间
			Date date=new Date();
			administrator.settName(username);
			administrator.settUuid(salt);
			administrator.settPassword(md5password);
			administrator.settCreatetime(date);
			int num = administratorMapperDao.insert(administrator);
			System.out.println("账号注册成功");
			return "succeed";
		}else {
			System.out.println("该账号已经存在");
			return "failed";
		}
	}
	
	/**
	 * 管理员账号进行登录
	 */
	@Override
	public String login(String username, String password) {
		//根据姓名查询管理员账号
		Administrator administrator = selectAdministrator(username);
		if(null != administrator){
			String uuid = administrator.gettUuid();
			String databasePassword = administrator.gettPassword();
			String md5password = EncryptedPassword(password,uuid);
			if(databasePassword.equals(md5password)){
				//System.out.println("登陆成功");
				return "succeed";
			}else {
				//System.out.println("账号或者密码失败");
				return "failed";
			}
		}else {
			return "failed";
		}
		
	}
	
}
