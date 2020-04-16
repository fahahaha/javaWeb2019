<%@page import="cn.edu.lingnan.dao.EnrolmentDAO"%>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%@page import="java.util.*,cn.edu.lingnan.dto.Customer" %>
    <%@page import="java.util.*,cn.edu.lingnan.dto.Room" %>
     <%@page import="java.util.*,cn.edu.lingnan.dto.Enrolment" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width,initial-scale=1" name="viewport">
  <meta content="description" name="description">
  <meta name="google" content="notranslate" />
  <meta content="Mashup templates have been developped by Orson.io team" name="author">
	<script type="text/javascript" src="register.js"></script>
	
  <!-- Disable tap highlight on IE -->
  <meta name="msapplication-tap-highlight" content="no">
  <link rel="apple-touch-icon" sizes="180x180" href="./assets/apple-icon-180x180.png">
  <link href="./assets/favicon.ico" rel="icon">
  <link href="" rel="stylesheet">
  <title>客人更新</title>

<link href="./main.550dcf66.css" rel="stylesheet"></head>

<body> <!-- Add your content of header -->
<header>

	


  <nav class="navbar navbar-default active">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="./index.html" title="">
          <img src="./assets/images/mashup-icon.svg" class="navbar-logo-img" alt="">
          宾  馆
        </a>
      </div>

      <div class="collapse navbar-collapse" id="navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href=loginoutadmin>注销</a><br></li>
          
          <li><a href="javascript:history.back(-1)">返回</a></li>
          <li>
            <p>
            <!--    <a href="./components.html" class="btn btn-default navbar-btn" title="">Components</a>-->
            </p>
          </li>

        </ul>
      </div> 
    </div>
  </nav>
   
</header>


<!-- Add your site or app content here -->
  <div class="hero-full-container background-image-container white-text-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1>欢迎更新客人信息</h1>
          <p>希望您在这里度过美好时光</p>
          <br>
          <a href="" class="btn btn-default btn-lg" title="">Welcome</a>
        </div>
      </div>
    </div>
  </div>

  <div class="section-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-md-8 col-md-offset-2">
          <div class="text-center">
            <h2>修改</h2>
            
            <style type="text/css">
	
	input{border-radius:9px;}
	td:hover{background-color: #66CCFF;}
	td{ border-width:1px 1px 1px 1px; padding:10px 0px;border-radius:20px;}
   table{
      
        width:800px;
    border-width:1px 0px 0px 1px;
    border-radius:25px;
 
    }
   
</style> 
<!-- 这里form改了 -->
<form action="updateCus">
<table>
<tr>
	<td>客人编号</td>
	<td>客人姓名</td>
	<td>密码</td>
	<td>权限</td>
	</tr>

<%
	Vector<Customer> v=(Vector<Customer>)session.getAttribute("allCus");
	Iterator<Customer> it=v.iterator();
	String sid =request.getParameter("cid");
	Customer c=null;
	while(it.hasNext()){
		c=it.next();
		if(c.getcId().equals(sid)){
			
		
%>
	<tr>
	<td><input type="text" name="cId" readonly="true" value=<%=c.getcId() %>></td>
	<td><input type="text" name="cName" value=<%=c.getcName() %>></td>
	<td><input type="text" name="cPassword" value=<%=c.getcPassword() %>></td>
	<td><input type="text" name="cSuper" value=<%=c.getcSuper() %>></td>
	<td><input type="submit" value="确认修改"></td>
	<td><input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页"></td>
	
	</tr>

<%
	}}
%>
</table>
</form>
            

             


          </div>
       </div>
      </div>
    </div>
  </div>

  

<script>
  document.addEventListener("DOMContentLoaded", function (event) {
    navbarFixedTopAnimation();
  });
</script>

<footer class="footer-container white-text-container">
  <div class="container">
    <div class="row">

     
      <div class="col-xs-12">
        <h3>宾馆</h3>

      
        
        
      </div>
    </div>
  </div>
</footer>

<script>
  document.addEventListener("DOMContentLoaded", function (event) {
    navActivePage();
    scrollRevelation('.reveal');
  });
</script>

<script type="text/javascript" src="./main.0cf8b554.js"></script>

</body>

</html>