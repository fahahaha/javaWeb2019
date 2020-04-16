package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.RoomDAO;
import cn.edu.lingnan.dto.Room;

public class UpdateRoomServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String f =req.getParameter("f");
		int flag=0;
		RoomDAO rd=new RoomDAO();
		if(f==null){
			//修改
				String rid=req.getParameter("rId");
				String rname=req.getParameter("rName");
				int rprice=Integer.parseInt(req.getParameter("rPrice"));
				int rstock=Integer.parseInt(req.getParameter("rStock"));
				Room r=new Room();
				r.setrId(rid);
				r.setrName(rname);
				r.setrStock(rstock);
				r.setrPrice(rprice);
				 rd=new RoomDAO();
				rd.updateRoom(r);	
				flag=rd.updateRoom(r);
		
		}
		else {
			//删除
			if(f.equals("delall")){
				String[] allrid=req.getParameterValues("allrid");
				String[] temp=allrid[0].split(",");//为什么是0
				for (String a :temp){
					rd.deleteRoom(a);
				}
				
				flag=1;
			}
			//删除一条
			else {
				String rid=req.getParameter("rid");
				 flag=rd.deleteRoom(rid);
			}
			
		}
		//更新刷新重新查找
		Vector<Room> v=rd.AllRoom();
		HttpSession s=req.getSession();
		s.setAttribute("allRoom", v);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/admin/allRoom.jsp");
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");

		}
	}

}
