package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.EnrolmentDAO;
import cn.edu.lingnan.dao.RoomDAO;
import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Enrolment;
import cn.edu.lingnan.dto.Room;

public class UpdateCusEnrolmentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String f =req.getParameter("f");
		int flag=0;
		
		EnrolmentDAO ed=new EnrolmentDAO();
		Room r=new Room();
		RoomDAO rd=new RoomDAO();
		Enrolment e=new Enrolment();
		Customer c=new Customer();
		if (f.equals("pay")){
			String rid=req.getParameter("rid");
			String cid=req.getParameter("cid");
			e.setcId(cid);
			e.setrId(rid);
			e.seteCheck("checkin");
			flag=ed.insertInfoToEnrolment(e);
		}else if(f.equals("delCus")){
			
			String cid=req.getParameter("cid");
			String rid=req.getParameter("rid");
			 flag=ed.deleteEnrolment(cid,rid);
			 if(flag==1)
			 rd.addRoom(rid);
		}
		
		Vector<Room> v=rd.AllRoom();
		HttpSession s=req.getSession();
		s.setAttribute("allRoom", v);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/ok.jsp");
		}else if(flag==3){
			System.out.println("该房间库存不足");
			resp.sendRedirect(req.getContextPath()+"/ok.jsp");
		}
		else if(flag==4){
			System.out.println("数据库句法错了或者不能重复插值！");
			resp.sendRedirect(req.getContextPath()+"/ok.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");

		}
	}
	
}
