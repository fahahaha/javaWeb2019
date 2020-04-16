

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


public class AdminRegisterEnrolmentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cid=req.getParameter("cid");
		String rid=req.getParameter("rid");
		String echeck=req.getParameter("echeck");
		
		EnrolmentDAO ed=new EnrolmentDAO();
		Enrolment e=new Enrolment();
		e.setcId(cid);
		e.setrId(rid);
		e.seteCheck(echeck);
		int flag=ed.insertInfoToEnrolment(e);
		//更新刷新重新查找
		Vector<Enrolment> v=ed.AllEnrolment();
		HttpSession s=req.getSession();
		s.setAttribute("allEnrolment", v);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/admin/allEnr.jsp");
			
			
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
	}
}
