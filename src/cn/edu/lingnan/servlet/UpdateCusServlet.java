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

public class UpdateCusServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String f =req.getParameter("f");
		int flag=0;
		CustomerDAO cd=new CustomerDAO();
		if(f==null){
			//修改
				String cid=req.getParameter("cId");
				String cname=req.getParameter("cName");
				String cpassword=req.getParameter("cPassword");
				int csuper=Integer.parseInt(req.getParameter("cSuper"));
				Customer c=new Customer();
				c.setcId(cid);
				c.setcName(cname);
				c.setcPassword(cpassword);
				c.setcSuper(csuper);
				 cd=new CustomerDAO();
				cd.updateCustomer(c);	
				flag=cd.updateCustomer(c);
		
		}
		else {
			//删除
			if(f.equals("delall")){
				String[] allcid=req.getParameterValues("allcid");
				String[] temp=allcid[0].split(",");//为什么是0
				for (String a :temp){
					cd.deleteCustomer(a);
				}
				
				flag=1;
			}
			//删除一条
			else {
				String cid=req.getParameter("cid");
				 flag=cd.deleteCustomer(cid);
			}
			
		}
		//更新刷新重新查找
		Vector<Customer> v=cd.AllCustomer();
		HttpSession s=req.getSession();
		s.setAttribute("allCus", v);
		if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/admin/allCus.jsp");
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");

		}
	}

}
