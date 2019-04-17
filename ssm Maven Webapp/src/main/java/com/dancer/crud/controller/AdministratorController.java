package com.dancer.crud.controller;
//�����޸ĺ��
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dancer.crud.service.AdministratorService;

/**
 * ����CRUD����
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;
	
	//ӳ�䣬��indexs.jsp�ļ�
	@RequestMapping(value="indexs.do", method = RequestMethod.GET)
	public String loginAndRegisterindexs(){
		return "modules/loginAndRegister/loginAndRegisterindexs";
	}
	
	
	
	/**
	 * �û�ע��
	 * @param name
	 * @param password
	 * @param boss
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="register.do", method = RequestMethod.POST)
	@ResponseBody		//@ResponseBody��ʾ���߿���������ֻ�����������ݣ�������ת������ҳ	(Ajax���ݲ���)
	public String register(@RequestParam("name") String name, @RequestParam("pwd") String password, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String a = administratorService.insertAdministrator(name,password);
		if(a == "succeed"){
			return "true";
		}else {
			return "false";
		}	
		
	}
	
	
	/**
	 * �û���¼
	 * @param name
	 * @param password
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	public String login(@RequestParam("name") String name, @RequestParam("pwd") String password, HttpSession session, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String a = administratorService.login(name,password);
		if(a == "succeed"){
			model.addAttribute("name", name);
			System.out.println("��½�ɹ�");
			return "modules/sys/index";
		}else {
			System.out.println("�˺Ż����������");
			model.addAttribute("error", "�˺Ż����������");
			return "modules/loginAndRegister/loginAndRegisterindexs";
		}
	}
	
	
}
