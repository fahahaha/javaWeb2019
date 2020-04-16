package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import cn.edu.lingnan.util.DataAccess;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 Connection conn=null;
		 PreparedStatement prep1=null;
			ResultSet rs1=null;
			conn=DataAccess.getConnection();
		//1.获取客户端提交的参数
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("LoginServlet:"+username+password);
		
		//给客户提供的客房信息
		RoomDAO rd=new RoomDAO();
		Vector<Room> v=rd.AllRoom();
		HttpSession s2=req.getSession();
		s2.setAttribute("allRoom", v);
		
		//记录客户id
		try {
			prep1=conn.prepareStatement("select * from customer where cName=?");
			prep1.setString(1, username);
		     rs1=prep1.executeQuery();
		    if(rs1.next()) {
		     String cid=rs1.getString("cId");
		     HttpSession s3=req.getSession();
				s3.setAttribute("cid", cid);
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		
		//2.处理参数，调用类方法，DAO里面方法
		Customer c=new Customer();
		CustomerDAO cd=new CustomerDAO();
		int cSuper=cd.login(username,password); 
		HttpSession s=req.getSession();
		HttpSession s1=req.getSession();
		s1.setAttribute("cName",username);
		s.setAttribute("cSuper", cSuper);
		//3.根据返回的结果进行处理，真去ok，假去error
		if(cSuper==2){
			resp.sendRedirect(req.getContextPath()+"/ok.jsp");
		}else if(cSuper==1){
			resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
			
		}
	}

}
