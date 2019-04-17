<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();    
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
// 将 ”项目路径basePath” 放入pageContext中，待以后用EL表达式读出。    
pageContext.setAttribute("basePath",basePath);    
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Modal Registration Form Template</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${pageScope.basePath}static/modules/loginAndRegister/assets/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageScope.basePath}static/modules/loginAndRegister/assets/css/form-elements.css">
        <link rel="stylesheet" href="${pageScope.basePath}static/modules/loginAndRegister/assets/css/style.css">
        <link rel="shortcut icon" href="${pageScope.basePath}static/modules/loginAndRegister/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageScope.basePath}static/modules/loginAndRegister/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageScope.basePath}static/modules/loginAndRegister/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageScope.basePath}static/modules/loginAndRegister/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${pageScope.basePath}static/modules/loginAndRegister/assets/ico/apple-touch-icon-57-precomposed.png">
        <script type="text/javascript" src="${pageScope.basePath}static/modules/loginAndRegister/loginAndRegisterindexs.js"></script>

</head>
    <body>   	   										 
        <!-- Content -->
        <div class="top-content">        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                        	<a class="logo" href="#"></a>
                        	<a class="logo@2x" href="#"></a>
                        	
                            <h1><strong>Keep On Dancing</strong> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<strong>D Dance Element</strong> </h1>
                            <div class="top-big-link">
                           		<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-login">管理员登陆</a>
                            	<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-register">管理员注册</a>                            	
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        												<!-- 注册页面 -->
        <!-- MODAL -->
        <div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">       			
        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-register-label" style=" text-align:center;">注册</h3>
        				<p>请填写下面表格:</p>
        			</div>
        			
        			<div class="modal-body">       				
	                    <form role="form" class="registration-form">
	                    	<div class="form-group">
	                    		<label class="sr-only" for="form-first-name">用户名</label>
	                        	<input type="text" name="name" placeholder="请输入用户名" class="form-first-name form-control" id="name">
	                        </div>
	                        <div class="form-group">
	                        	<label class="sr-only" for="form-last-name">密码</label>
	                        	<input type="password" name="pwd" placeholder="请输入密码" class="form-last-name form-control" id="pwd">
	                        </div>
	             			<div class="form-group">
	                        	<label class="sr-only" for="form-last-name">确认密码</label>
	                        	<input type="password" name="pwd1" placeholder="再次输入密码，保证两次密码一致" class="form-last-name form-control" id="pwd1">
	                        </div>
	                        <div class="form-group">
	                        	<label class="sr-only" for="form-last-name">超级管理员</label>
	                        	<input type="password" name="boss" placeholder="Boss" class="form-last-name form-control" id="boss">
	                        </div>
	                        <button type="button" class="btn" onclick="register()">注册</button>
	                    </form>
        			</div>
        		</div>
        	</div>
        </div>
		

        <!-- Javascript -->
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/js/jquery-1.11.1.min.js"></script>
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/js/jquery.backstretch.min.js"></script>
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
        
        
        
        
        
       												 <!-- 登陆页面 -->
        <!-- MODAL -->
        <div class="modal fade" id="modal-login" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content">       			
        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-register-label" style=" text-align:center;">登陆</h3>
        				<p>Keep On Dancing:</p>
        			</div>
        			
        			<div class="modal-body">       				
	                    <form role="form" action="" method="post" class="registration-form">
	                    	<div class="form-group">
	                    		<label class="sr-only" for="form-first-name">用户名</label>
	                        	<input type="text" name="loginname" placeholder="请输入用户名" class="form-first-name form-control" id="loginname">
	                        </div>
	                        <div class="form-group">
	                        	<label class="sr-only" for="form-last-name">密码</label>
	                        	<input type="password" name="loginpwd" placeholder="请输入密码" class="form-last-name form-control" id="loginpwd">
	                        </div>
	                        <button type="button" class="btn" onclick=login()>登陆</button>
	                    </form>
        			</div>
        		</div>
        	</div>
        	<div id="showResult"></div>
        </div>
        
        
        <%
        	if(null!=request.getAttribute("error")){
		 %>
		 <div>
		<font size="15" face="arial" color="white"><%=request.getAttribute("error")%></font>
		</div>	
		<%	
        	}
         %>
		
		
        <!-- Javascript -->
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/js/jquery-1.11.1.min.js"></script>
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/js/jquery.backstretch.min.js"></script>
        <script src="${pageScope.basePath}static/modules/loginAndRegister/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
        
				
    </body>
</html>