package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.EnrolmentDAO;
import cn.edu.lingnan.dto.Enrolment;

public class AllEnrolmentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		//调用DAO
		EnrolmentDAO ed=new EnrolmentDAO();
		Vector<Enrolment> v=ed.AllEnrolment();
		HttpSession s=req.getSession();
		s.setAttribute("allEnrolment", v);
		//返回allcus.jsp页面并显示查找到所有用户信息
		resp.sendRedirect(req.getContextPath()+"/admin/allEnr.jsp");
}
}
