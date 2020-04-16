
package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.CustomerDAO;
import cn.edu.lingnan.dao.RoomDAO;
import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Room;

public class AdminRegisterRoomServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rid=req.getParameter("rid");
		String rname=req.getParameter("rname");
		String rprice=req.getParameter("rprice");
		String rstock=req.getParameter("rstock");
		
		RoomDAO rd=new RoomDAO();
		Room r=new Room();
		r.setrId(rid);
		r.setrName(rname);
		r.setrPrice(Integer.parseInt(rprice));
		r.setrStock(Integer.parseInt(rstock));
		int flag=rd.insertInfoToRoom(r);
		//更新刷新重新查找
		Vector<Room> v=rd.AllRoom();
		HttpSession s=req.getSession();
		s.setAttribute("allRoom", v);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/admin/allRoom.jsp");
			
			
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
	}
}
