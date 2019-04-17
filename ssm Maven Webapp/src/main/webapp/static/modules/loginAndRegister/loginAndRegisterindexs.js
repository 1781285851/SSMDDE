//获取当前项目名称路径（http://localhost:8080/ssm/）
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName + '/';
}



//登陆
function login(){
	var name=document.getElementById("loginname").value;
	var pwd=document.getElementById("loginpwd").value;
	//window.location.href = getRootPath()+"login.do?name="+name+"&pwd="+pwd;
	
	//带数据以post方式进行转发
	document.write("<form action="+getRootPath()+"login.do method=post name=formx1 style='display:none'>");
	document.write("<input type=hidden name=name value='"+name+"'>");
	document.write("<input type=hidden name=pwd value='"+pwd+"'>");
	document.write("</form>");
	document.formx1.submit();
	
	/*
	$.ajax({
		type:"POST",
		url:getRootPath()+"login.do",
		dataType:"json",
		data:{
			name:name,
			pwd:pwd
		},
		success:function(result){
			if(result == false){
				alert("登陆失败，密码或账号出错！");
				window.location.href = getRootPath()+"indexs.do";
			}else if(result == true){
				window.location.href = getRootPath()+"index.do";
			}
		}
	});
	*/
}




//注册
function register(){
	var name=document.getElementById("name").value;
	var pwd=document.getElementById("pwd").value;
	var pwd1=document.getElementById("pwd1").value;
	var boss=document.getElementById("boss").value;
	if(pwd==pwd1&&boss=="1"){
		$.ajax({
			type:"POST",
			url:getRootPath()+"register.do",
			dataType:"json",
			data:{
				name:name,
				pwd:pwd,
			},
			success:function(result,testStatus){//result代表从后台controller的return值，但是前台controller需要@ResponseBody注解
				if(result == true){
					alert("注册成功");
					window.location.href=getRootPath()+"indexs.do";
				}else if(result == false){
					alert("该用户名已存在，注册失败！！");
				}
			}
		});
		
	}else {
		alert("两次密码不一致,或者'Boss'输入错误");
	}	
}