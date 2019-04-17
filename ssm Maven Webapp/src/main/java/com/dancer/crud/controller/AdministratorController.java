package com.dancer.crud.controller;
//这是修改后的
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
 * 处理CRUD请求
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	
	@Autowired
	AdministratorService administratorService;
	
	//映射，打开indexs.jsp文件
	@RequestMapping(value="indexs.do", method = RequestMethod.GET)
	public String loginAndRegisterindexs(){
		return "modules/loginAndRegister/loginAndRegisterindexs";
	}
	
	
	
	/**
	 * 用户注册
	 * @param name
	 * @param password
	 * @param boss
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value="register.do", method = RequestMethod.POST)
	@ResponseBody		//@ResponseBody表示告诉控制器，我只返回数据内容，而不是转发回网页	(Ajax传递参数)
	public String register(@RequestParam("name") String name, @RequestParam("pwd") String password, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String a = administratorService.insertAdministrator(name,password);
		if(a == "succeed"){
			return "true";
		}else {
			return "false";
		}	
		
	}
	
	
	/**
	 * 用户登录
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
			System.out.println("登陆成功");
			return "modules/sys/index";
		}else {
			System.out.println("账号或者密码错误");
			model.addAttribute("error", "账号或者密码错误");
			return "modules/loginAndRegister/loginAndRegisterindexs";
		}
	}
	
	
}
