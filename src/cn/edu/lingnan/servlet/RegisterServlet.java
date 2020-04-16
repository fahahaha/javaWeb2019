package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.CustomerDAO;
import cn.edu.lingnan.dto.Customer;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cid=req.getParameter("cid");
		String cname=req.getParameter("username");
		String cpassword=req.getParameter("password1");
		String csuper=req.getParameter("cSuper");
		
		CustomerDAO cd=new CustomerDAO();
		Customer c=new Customer();
		c.setcId(cid);
		c.setcName(cname);
		c.setcPassword(cpassword);
		c.setcSuper(Integer.parseInt(csuper));
		int flag=cd.insertInfoToCustomer(c);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/login.html");
			
			
		}else{
			System.out.println("错误");
			resp.sendRedirect(req.getContextPath()+"/register.jsp");
		}
	}
}
