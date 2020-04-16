package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CustomerDAO;
import cn.edu.lingnan.dto.Customer;

public class AllCustomerServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		
			throws ServletException, IOException {
		//调用DAO
		CustomerDAO cd=new CustomerDAO();
		Vector<Customer> v=cd.AllCustomer();
		HttpSession s=req.getSession();
		s.setAttribute("allCus", v);
		//返回allcus.jsp页面并显示查找到所有用户信息
		resp.sendRedirect(req.getContextPath()+"/admin/allCus.jsp");
	

	}
}
