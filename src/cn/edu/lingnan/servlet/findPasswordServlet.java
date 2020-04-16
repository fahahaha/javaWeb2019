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

public class findPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	
			throws ServletException, IOException {
		//忘记密码的用户需要填写客户编号和名字
		String cid=req.getParameter("cid");
		String cname=req.getParameter("username");
		String cpassword="无信息";
		//调用DAO
		CustomerDAO cd=new CustomerDAO();
		cpassword=cd.findpassword(cid, cname);
		HttpSession s=req.getSession();
		//将密码存下
		s.setAttribute("cPassword", cpassword);
		resp.sendRedirect(req.getContextPath()+"/findpassword.jsp");
	

	}
}
