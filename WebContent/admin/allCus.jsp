<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%@page import="java.util.*,cn.edu.lingnan.dto.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta content="width=device-width,initial-scale=1" name="viewport">
  <meta content="description" name="description">
  <meta name="google" content="notranslate" />
  <meta content="Mashup templates have been developped by Orson.io team" name="author">
	<script type="text/javascript" src="allCus.js"></script>
	
  <!-- Disable tap highlight on IE -->
  <meta name="msapplication-tap-highlight" content="no">
  
  
  <link rel="apple-touch-icon" sizes="180x180" href="./assets/apple-icon-180x180.png">
  <link href="./assets/favicon.ico" rel="icon">

  <link href="" rel="stylesheet">


  <title>���˹���</title>

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
          ��  ��
        </a>
      </div>

      <div class="collapse navbar-collapse" id="navbar-collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="../loginout">ע��</a><br></li>
          
          <li><a href="javascript:history.back(-1)">����</a></li>
          <li>
            <p>
              <!--<a href="./components.html" class="btn btn-default navbar-btn" title="">Components</a>  -->
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
          <h1>������Ϣ��</h1>
          <p>ϣ����������ȹ�����ʱ��</p>
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
            <h2>���˻�����Ϣ</h2>
            
 <style type="text/css">
	
	input{border-radius:9px;}
	td:hover{background-color: #66CCFF;}
	td{border:solid #0099FF; border-width:1px 1px 1px 1px; padding:10px 0px;border-radius:20px;}
   table{
      
        width:800px;
    border-width:1px 0px 0px 1px;
    border-radius:25px;
 
    }
   
</style>
            <table >
	<tr>
	<td><input id="btn1" type="button"  value="ȫѡ" onclick="allCheck();"/></td>
	<td>���˱��</td>
	<td>��������</td>
	<td>����</td>
	<td>Ȩ��</td>
	<td><input id="btn2" type="button" value="����ɾ��" onclick="delAllCus();"/></td>
	<td><input id="btn3" type="button" value="��ѡ" onclick="allCheck1();"/></td>
	</tr>
<%
//ҳ����ת���غ�����û�и��£���session���Խ��
	Vector<Customer> v=(Vector<Customer>)session.getAttribute("allCus");
	Iterator<Customer> it=v.iterator();
	Customer c=null;
	while(it.hasNext()){
		c=it.next();
		if(!c.getcId().equals("c00")){
%>
	<tr>
	<td><input type="checkbox" name="check" value=<%=c.getcId() %>></td>
	<td><%=c.getcId() %></td>
	<td><%=c.getcName() %></td>
	<td><%=c.getcPassword() %></td>
	<td><%=c.getcSuper() %></td>
	<td><a href="updateCus.jsp?cid=<%=c.getcId() %>">�޸�</a>
	</td>
	<td>
	<a href="updateCus?f=del&cid=<%=c.getcId() %>"
	onclick="return confirm('��ȷ��Ҫɾ��������¼��');">ɾ��</a></td>
	</tr>
<%
		}
	}
%>
</table>


<!-- �����ǲ�������� -->
<form action="adminregister">
 <table >
	<tr>
	<td>���˱��</td>
	<td>��������</td>
	<td>����</td>
	<td>Ȩ��</td>
	<td></td>
	</tr>
	
	<tr>
	<td><input type="text" name="cid" id="cid"></td>
	<td><input type="text" name="username" id="username"></td>
	<td><input type="text" name="password1" id="password1"></td>
	<td><input type="text" name="cSuper" id="cSuper"></td>
	<td><input type="submit" value="ȷ�ϲ���" onclick="return confirm('��ȷ��Ҫ���������¼��');" ></td>
	
	</tr>
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
        <h3>����</h3>

       
        
        
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