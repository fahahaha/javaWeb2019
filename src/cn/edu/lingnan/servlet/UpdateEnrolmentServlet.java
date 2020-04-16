package cn.edu.lingnan.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.EnrolmentDAO;
import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Enrolment;

public class UpdateEnrolmentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String f =req.getParameter("f");
		int flag=0;
		int flag1=0;
		EnrolmentDAO ed=new EnrolmentDAO();
		Enrolment e=new Enrolment();
		Customer c=new Customer();
		if(f==null){
			//修改
				String cid=req.getParameter("cId");
				String rid=req.getParameter("rId");
				String echeck=req.getParameter("eCheck");
				e.setcId(cid);
				e.setrId(rid);
				e.seteCheck(echeck);
				 ed=new EnrolmentDAO();
				ed.updateEnrolment(e);	
				flag=ed.updateEnrolment(e);
		
		}
		  
			//删除
		else if(f.equals("delall")){
				String[] allcid=req.getParameterValues("allcid");
				String[] allrid=req.getParameterValues("allrid");
				String[] temp1=allcid[0].split(",");//为什么是0
				String[] temp2=allrid[0].split(",");//为什么是0
				for (int i=0;i<temp1.length;i++)
					ed.deleteEnrolment(temp1[i],temp2[i]);
				
				
				flag=1;
			}
			//删除一条
			else {
				String cid=req.getParameter("cid");
				String rid=req.getParameter("rid");
				 flag=ed.deleteEnrolment(cid,rid);
			}
			
		
		//更新刷新重新查找
		Vector<Enrolment> v=ed.AllEnrolment();
		HttpSession s=req.getSession();
		s.setAttribute("allEnrolment", v);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/admin/allEnr.jsp");
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");

		}
	}

}
