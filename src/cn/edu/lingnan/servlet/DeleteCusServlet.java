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

public class DeleteCusServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		//1
//		
//				String cid=req.getParameter("cid");
//		//2
//				CustomerDAO cd=new CustomerDAO();
//				int flag=cd.deleteCustomer(cid);
//				
//				//更新刷新重新查找
//				Vector<Customer> v=cd.AllCustomer();
//				HttpSession s=req.getSession();
//				s.setAttribute("allCus", v);
//		//3
//				if(flag==1){
//					resp.sendRedirect(req.getContextPath()+"/admin/allCus.jsp");
//				}
//				else{
//					resp.sendRedirect(req.getContextPath()+"/error.html");
//
//				}
	}
}
