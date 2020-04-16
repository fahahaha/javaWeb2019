package cn.edu.lingnan.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Enrolment;
import cn.edu.lingnan.dto.Room;
import cn.edu.lingnan.util.DataAccess;

public class CustomerDAO {
//使用preparement更加安全
	public int login(String _name,String _password){
		 Connection conn=null;
			//Statement stat=null;
		 PreparedStatement prep=null;
			ResultSet rs=null;
			int flag=0;
		try {
			conn=DataAccess.getConnection();
//			 stat=conn.createStatement();
//			 String sql="select * from customer where cName='"+_name+"'and cPassword='"+_password+"' ";
//			 rs=stat.executeQuery(sql);
		     prep=conn.prepareStatement("select * from customer where cName=? and cPassword=?");
		     prep.setString(1, _name);
		     prep.setString(2, _password);
		     rs=prep.executeQuery();
			 if(rs.next()) {
				 flag=rs.getInt("cSuper");
			 }
		
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
//			try {
//				if(rs!=null)
//				rs.close();
//				if(prep!=null)
//				prep.close();
//				if(conn!=null)
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			DataAccess.closeConnection(rs, prep, conn);
		}

		return flag;
	}
//用于网页数据传输的
	public Vector<Customer> AllCustomer(){
		Vector<Customer> v=new Vector<Customer>();
		 Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
//			若出现很多个连接数据库语句的java，将很大工程所以要用工具包
//			Class.forName("com.mysql.jdbc.Driver");
//		     conn=DriverManager.getConnection
//		    ("jdbc:mysql://localhost:3306/hotel", "root", "123456");
			conn=DataAccess.getConnection();
			 stat=conn.createStatement();
			 String sql="select * from customer ";
			 rs=stat.executeQuery(sql);
			 while(rs.next()) {
				Customer c=new Customer();
				c.setcId(rs.getString("cId"));
				c.setcName(rs.getString("cName"));
				c.setcPassword(rs.getString("cPassword"));
				c.setcSuper(rs.getInt("cSuper"));
				v.add(c);
			 }
		
			
		}
//		catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeConnection(rs, stat, conn);
			
		}

		
		
		return v;
	}
//用于testDAO封面的
	public Vector<Customer> findAllCustomer(){
		Vector<Customer> v=new Vector<Customer>();
		 Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
//			若出现很多个连接数据库语句的java，将很大工程所以要用工具包
//			Class.forName("com.mysql.jdbc.Driver");
//		     conn=DriverManager.getConnection
//		    ("jdbc:mysql://localhost:3306/hotel", "root", "123456");
			conn=DataAccess.getConnection();
			 stat=conn.createStatement();
			 String sql="select * from customer ";
			 rs=stat.executeQuery(sql);
			 System.out.println("客人编号 |  客人名字  | 客人密码 |客人权限|");
			 while(rs.next()) {
				Customer c=new Customer();
				c.setcId(rs.getString("cId"));
				c.setcName(rs.getString("cName"));
				c.setcPassword(rs.getString("cPassword"));
				c.setcSuper(rs.getInt("cSuper"));
				
				System.out.println(c.getcId()+"     |"+c.getcName()+"| "+c.getcPassword()+"    |   "+c.getcSuper()+"   | ");
				System.out.println("---------------------------------------");
				v.add(c);
			 }
		
			
		}
//		catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeConnection(rs, stat, conn);
			
		}

		
		
		return v;
	}

	//插入客人号
		public int insertInfoToCustomer(Customer c) {
			int flag=0;
			
			String cId=c.getcId();
			String cName=c.getcName();
			String cPassword=c.getcPassword();
			int cSuper=c.getcSuper();
			
			 Connection conn=null;
				//Statement stat=null;
			 PreparedStatement prep=null;
			 PreparedStatement prep2=null;
			 PreparedStatement prep3=null;
				ResultSet rs=null;
				ResultSet rs2=null;
				ResultSet rs3=null;
			try {
				conn=DataAccess.getConnection();
//				 stat=conn.createStatement();
//				 String sql="select * from Enrolment where cId='"+_name+"'and rId='"+_password+"' ";
//				 rs=stat.executeQuery(sql);
			     
//			     //假设客人号不存在
//			     prep2=conn.prepareStatement("select * from customer where cId=?");
//			     prep2.setString(1, cId);
//			     rs2=prep2.executeQuery();
//			     while(!rs2.next()) {
//			    	 flag=2;
//			    	 return flag;
//			     }
//			     
//			     //假设房间号不存在
//			     prep3=conn.prepareStatement("select * from room where rId=?");
//			     prep3.setString(1, rId);
//			     rs3=prep3.executeQuery();
//			     while(!rs3.next()) {
//			    	 flag=3;
//			    	 return flag;
//			     }
			     
			     //假设客人号和房间号都存在
			     prep=conn.prepareStatement("insert into customer values(?,?,?,?)");
			     prep.setString(1, cId);
			     prep.setString(2, cName);
			     prep.setString(3, cPassword);
			     prep.setInt(4, cSuper);
			     prep.executeUpdate();
			     flag=1;
			
				
				
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				flag=4;
			}finally {
				try {
					if(rs3!=null)
						rs3.close();
					if(rs2!=null)
						rs2.close();
					if(rs!=null)
					rs.close();
					if(prep3!=null)
						prep3.close();
					if(prep2!=null)
						prep2.close();
					if(prep!=null)
					prep.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}

			return flag;
		}
		//更新
		public int updateCustomer(Customer c) {
			int flag=0;
			String cId=c.getcId();
			String cName=c.getcName();
			String cPassword=c.getcPassword();
			int cSuper=c.getcSuper();
			Connection conn=null;
			PreparedStatement prep1=null;
			PreparedStatement prep=null;
			ResultSet rs1=null;
			ResultSet rs=null;
		try {
			   conn=DataAccess.getConnection();
			   //检测id是否存在
			   prep1=conn.prepareStatement("select count(*) as num from customer where cId=?");
				prep1.setString(1, cId);
				rs1=prep1.executeQuery();
				rs1.next();
				if(Integer.parseInt(rs1.getString("num"))==0) {
					System.out.println("该客人编号不存在！\n");
					flag=2;
					return flag;
				}
				//----------------------------------------------

			prep=conn.prepareStatement("update customer set cName=?,cPassword=?,cSuper=? where cId=?");
			prep.setString(1, cName);
			prep.setString(2, cPassword);
			prep.setInt(3, cSuper);
			prep.setString(4, cId);
			prep.executeUpdate();
			
			flag=1;
		} 
		catch (SQLException e1) {
			flag=3;
			System.out.println("数据库语句语法出现错误！");
			e1.printStackTrace();
		}finally {
			try {
				if(rs1!=null)
				rs1.close();
					if(prep1!=null)
					prep1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	DataAccess.closeConnection(rs, prep, conn);
		}
			
			return flag;
		}
		//删除
		public int deleteCustomer(String _cid) {
			int flag=0;
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			PreparedStatement prep5=null;
			PreparedStatement prep4=null;
			PreparedStatement prep3=null;
			PreparedStatement prep2=null;
			PreparedStatement prep1=null;
			ResultSet rs5=null;
			ResultSet rs3=null;
			ResultSet rs2=null;
		try {
			   conn=DataAccess.getConnection();
			   //首先检测该id是否存在
			   prep5=conn.prepareStatement("select count(*) as numcid from customer where cId=?");
			   prep5.setString(1, _cid);
			   rs5=prep5.executeQuery();
			   rs5.next();
			   if(Integer.parseInt(rs5.getString("numcid"))==0) {
				   System.out.println("该客人编号不存在！\n");
				   flag=2;
				   return flag;
			   }
			   //-----------------------------
			   prep2=conn.prepareStatement("select * from enrolment where cid=?");
			   prep2.setString(1, _cid);
		       rs2=prep2.executeQuery();
		       Vector<String> v=new Vector<String>();
		       while(rs2.next()) {
//出现的rid ，再判断是否只有上面的cid一个人选了，若等于1，则可以删除Room
		    	   prep3=conn.prepareStatement("select count(*) as num from enrolment where rId=?");
		    	   prep3.setString(1,rs2.getString("rId"));
		    	   rs3=prep3.executeQuery();
		    	   
		    	   rs3.next();
		    	   //System.out.println(rs2.getString("rId")+"     "+rs3.getString("num"));
		    	   if(Integer.parseInt(rs3.getString("num"))==1) {
		    		   v.add(rs2.getString("rId"));
		    		   //不能先删房间表，出现外键错误
//		    		   prep4=conn.prepareStatement("delete from room where rid=?");
//		    		   prep4.setString(1, rs2.getString("rId"));
//		    		   prep4.executeUpdate();
		    	   }
		       }
		       conn.setAutoCommit(false);
			   //先删除登记表，再删除客人。
			   prep1=conn.prepareStatement("delete from enrolment where cId=?");
			   prep1.setString(1, _cid);
		       prep1.executeUpdate();
			   //删除客人----------------------------
			   
		       prep=conn.prepareStatement("delete from customer where cId=?");
		       prep.setString(1, _cid);
		       prep.executeUpdate();
			//删除房间
		       for(String a:v) {
		    	   prep4=conn.prepareStatement("delete from room where rid=?");
		    	   prep4.setString(1, a);
		    	   prep4.executeUpdate();
			}
		       conn.commit();
		       conn.setAutoCommit(true);
			
		       flag=1;
		} 
		catch (SQLException e1) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				flag=3;
				System.out.println("数据库语句语法错误！\n");
				e.printStackTrace();
			}
			e1.printStackTrace();
		}finally {
			
				try {
					if(rs2!=null)
					rs2.close();
					if(rs3!=null)
						rs3.close();
						if(prep1!=null)
						prep1.close();
						if(prep2!=null)
							prep2.close();
						if(prep3!=null)
							prep3.close();
						if(prep4!=null)
							prep4.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				
	DataAccess.closeConnection(rs, prep, conn);
		}
			
			return flag;
		}
		public String findpassword (String _cid,String _cname){
			 Connection conn=null;
				//Statement stat=null;
			 PreparedStatement prep=null;
				ResultSet rs=null;
				String cpassword="请提供有效信息,才可查找成功！";
				int flag=0;
			try {
				conn=DataAccess.getConnection();
//				 stat=conn.createStatement();
//				 String sql="select * from customer where cName='"+_name+"'and cPassword='"+_password+"' ";
//				 rs=stat.executeQuery(sql);
			     prep=conn.prepareStatement("select cPassword from customer where cName=? and cId=?");
			     prep.setString(1, _cname);
			     prep.setString(2, _cid);
			     rs=prep.executeQuery();
				 if(rs.next()) {
					 cpassword=rs.getString("cPassword");
					
					 
				 }
				 
					
				
			
				
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
//				try {
//					if(rs!=null)
//					rs.close();
//					if(prep!=null)
//					prep.close();
//					if(conn!=null)
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
				DataAccess.closeConnection(rs, prep, conn);
			}

			 return cpassword;
		}
		
}
