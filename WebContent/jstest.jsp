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
	<script type="text/javascript" src="jstest.js"></script>
	
  <!-- Disable tap highlight on IE -->
  <meta name="msapplication-tap-highlight" content="no">
  <link rel="apple-touch-icon" sizes="180x180" href="./assets/apple-icon-180x180.png">
  <link href="./assets/favicon.ico" rel="icon">
  <link href="" rel="stylesheet">
  <title>登录成功！</title>

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
        <a class="navbar-brand" href="" title="">
          <img src="./assets/images/mashup-icon.svg" class="navbar-logo-img" alt="">
          宾  馆 
        </a>
      </div>

      <div class="collapse navbar-collapse" id="navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="loginout">注销</a><br></li>
          
          <li><a href="javascript:history.back(-1)">返回</a></li>
          <li>
            <p>
             <!--  <a href="./components.html" class="btn btn-default navbar-btn" title="">Components</a>-->
            </p>
          </li>

        </ul>
      </div> 
    </div>
  </nav>
   
</header>
<%
	Enrolment e=new Enrolment();
	EnrolmentDAO ed=new EnrolmentDAO();
	Customer c=new Customer();
	String cName=(String)session.getAttribute("cName");
	String cid=(String)session.getAttribute("cid");
	e.setcId(cid);
	c.setcName(cName);
%>
   <input type=”hidden“ name=“a” id="a" value="<%=cid%>">

<!-- Add your site or app content here -->
  <div class="hero-full-container background-image-container white-text-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1>欢迎您！<%=c.getcName() %>，登录订房系统</h1>
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
            <h2>房间基本信息</h2>
            
          

  <style>
        #box{width:250px;height:300px;border:1px solid #e5e5e5;background:#f1f1f1;}
    </style>

 <div id="box"></div>
<span id="span1">张三：</span>
<input type="text" id="text1"/>
<input id="Btn" type="button" value="按钮" name="" onclick="send();" />
<p id="demo">未显示时间</p>
<button type="button" onclick="displayDate()">显示日期</button>

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