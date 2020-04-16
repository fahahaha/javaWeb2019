package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Enrolment;
import cn.edu.lingnan.util.DataAccess;

public class EnrolmentDAO {

	public boolean findEnrolmentByNameAndPassword(String _name,String _password){
		 Connection conn=null;
			//Statement stat=null;
		 PreparedStatement prep=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
			   conn=DataAccess.getConnection();
//			 stat=conn.createStatement();
//			 String sql="select * from Enrolment where cId='"+_name+"'and rId='"+_password+"' ";
//			 rs=stat.executeQuery(sql);
		     prep=conn.prepareStatement("select * from Enrolment where cId=? and rId=?");
		     prep.setString(1, _name);
		     prep.setString(2, _password);
		     rs=prep.executeQuery();
			 if(rs.next()) {
				 flag=true;
			 }
		
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
		DataAccess.closeConnection(rs, prep, conn);
			
		}

		return flag;
	}
//用于Web
	public Vector<Enrolment> AllEnrolment(){
		Vector<Enrolment> v=new Vector<Enrolment>();
		 Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
			   conn=DataAccess.getConnection();
			 stat=conn.createStatement();
			 String sql="select * from Enrolment ";
			 rs=stat.executeQuery(sql);
			 while(rs.next()) {
				 Enrolment e=new Enrolment();
				e.setcId(rs.getString("cId"));
				e.setrId(rs.getString("rId"));
				e.seteCheck(rs.getString("eCheck"));
				v.add(e);
			 }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeConnection(rs, stat, conn);
		}
		return v;
	}	
	//用于Web客人购买记录
		public Vector<Enrolment> AllPayEnrolment(Customer c){
			Vector<Enrolment> v=new Vector<Enrolment>();
			 Connection conn=null;
				Statement stat=null;
				ResultSet rs=null;
				PreparedStatement prep1=null;
				ResultSet rs1=null;
				PreparedStatement prep2=null;
				ResultSet rs2=null;
			try {
				conn=DataAccess.getConnection();
				prep1=conn.prepareStatement("select * from Customer where cName=?");
			     prep1.setString(1, c.getcName());
			     rs1=prep1.executeQuery();
			     while(rs1.next()) {
			     String cid=rs1.getString("cId");
			     prep2=conn.prepareStatement("select * from Enrolment where cId=?");
			     prep2.setString(1,cid);
			     rs2=prep2.executeQuery();
			     
				 while(rs2.next()) {
					 
					 String rid=rs2.getString("rId");
					 String echeck=rs2.getString("eCheck");
						Enrolment e=new Enrolment();
						e.setcId(cid);
						e.setrId(rid);
						e.seteCheck(echeck);
						v.add(e);
					 
				 }
			     }
				
				   
				 
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DataAccess.closeConnection(rs, stat, conn);
			}
			return v;
		}	
//用于testDAO
	public Vector<Enrolment> findAllEnrolment(){
		Vector<Enrolment> v=new Vector<Enrolment>();
		 Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
			   conn=DataAccess.getConnection();
			 stat=conn.createStatement();
			 String sql="select * from Enrolment ";
			 rs=stat.executeQuery(sql);
			 System.out.println("客人编号 |房间编号| 入住状态 |");
			 while(rs.next()) {
				 Enrolment e=new Enrolment();
				e.setcId(rs.getString("cId"));
				e.setrId(rs.getString("rId"));
				e.seteCheck(rs.getString("eCheck"));
				
				System.out.println(e.getcId()+"     |  "+e.getrId()+"  | "+e.geteCheck()+"| ");
				System.out.println("---------------------------------------");
				v.add(e);
			 }
		
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataAccess.closeConnection(rs, stat, conn);
			
		}

		
		
		return v;
	}
//插入客人和房间的登记信息
	public int insertInfoToEnrolment(Enrolment e) {
		int flag=0;
		
		String cId=e.getcId();
		String rId=e.getrId();
		String eCheck=e.geteCheck();
		
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
		   
//			 stat=conn.createStatement();
//			 String sql="select * from Enrolment where cId='"+_name+"'and rId='"+_password+"' ";
//			 rs=stat.executeQuery(sql);
		     
		     //假设客人号不存在
//		     prep2=conn.prepareStatement("select * from customer where cId=?");
//		     prep2.setString(1, cId);
//		     rs2=prep2.executeQuery();
//		     while(!rs2.next()) {
//		    	 flag=2;
//		    	 return flag;
//		     }
//		     
//		     //假设房间号不存在
//		     prep3=conn.prepareStatement("select * from room where rId=?");
//		     prep3.setString(1, rId);
//		     rs3=prep3.executeQuery();
//		     while(!rs3.next()) {
//		    	 flag=3;
//
//		    	 return flag;
//		     }
		     //假设房间库存不足
		     prep3=conn.prepareStatement("select rStock from room where rId=?");
		     prep3.setString(1, rId);
		     rs3=prep3.executeQuery();
		     rs3.next();
		     if(rs3.getInt("rStock")==0){
		    	 flag=3;
		    	 return flag;

		     }

		    
		     //假设客人号和房间号都存在
		     prep=conn.prepareStatement("insert into enrolment values(?,?,?)");
		     prep.setString(1, cId);
		     prep.setString(2, rId);
		     prep.setString(3, eCheck);
		     prep.executeUpdate();
		     flag=1;
		     if(flag==1){
		    	 prep2=conn.prepareStatement("update room set rStock=rStock-1 where rId=?");
			     prep2.setString(1, rId);
			     prep2.executeUpdate();

		     }
		     
		
			
			
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
	
	public int updateEnrolment(Enrolment e) {
		int flag=0;
		String cId=e.getcId();
		String rId=e.getrId();
		String echeck=e.geteCheck();	
        Connection conn=null;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
	try {
		   conn=DataAccess.getConnection();
		 //检测id是否存在
		   prep1=conn.prepareStatement("select count(*) as num from enrolment where cId=? and rId=?");
			prep1.setString(1, cId);
			prep1.setString(2, rId);
			rs1=prep1.executeQuery();
			rs1.next();
			if(Integer.parseInt(rs1.getString("num"))==0) {
				System.out.println("该条登记数据不存在！\n");
				flag=2;
				return flag;
			}
			//----------------------------------------------
		prep=conn.prepareStatement("update enrolment set echeck=? where cId=? and rId=?");
		prep.setString(1, echeck);
		prep.setString(2, cId);
		prep.setString(3, rId);
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
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
DataAccess.closeConnection(rs, prep, conn);
	}
	
		return flag;
	}
	//删除
	public int deleteEnrolment(String _cid,String _rid) {
				int flag=0;
				Connection conn=null;
				PreparedStatement prep5=null;
				PreparedStatement prep4=null;
				PreparedStatement prep3=null;
				PreparedStatement prep2=null;
				PreparedStatement prep1=null;
				PreparedStatement prep=null;
				ResultSet rs5=null;
				ResultSet rs3=null;
				ResultSet rs2=null;
				ResultSet rs1=null;
				ResultSet rs=null;
				Statement stat=null;
			try {
				   conn=DataAccess.getConnection();
				   //首先检测该id是否存在
				   prep5=conn.prepareStatement("select count(*) as numcrid from enrolment where cId=? and rId=?");
				   prep5.setString(1, _cid);
				   prep5.setString(2, _rid);
				   rs5=prep5.executeQuery();
				   rs5.next();
				   if(Integer.parseInt(rs5.getString("numcrid"))==0) {
					   System.out.println("该条登记数据不存在！\n");
					   flag=2;
					   return flag;
				   }
				   //-----------------------------
				   prep1=conn.prepareStatement("delete from enrolment where cId=? and rId=?");
				   prep1.setString(1, _cid);
				   prep1.setString(2, _rid);
			       prep1.executeUpdate();
			       //删除登记表后，检测如果客人和房间都为1，则进行删除客人和房间表的操作
			       //删除客人
//			       prep3=conn.prepareStatement("select count(*) as num from enrolment where cId=?");
//		    	   prep3.setString(1,_cid);
//		    	   rs3=prep3.executeQuery();
//		    	   rs3.next();
//		    	   if(Integer.parseInt(rs3.getString("num"))==0) {
//		    		   prep=conn.prepareStatement("delete from customer where cId=?");
//				       prep.setString(1, _cid);
//				       prep.executeUpdate();
//		    		   
//		    	   }
		    	   //删除房间
//		    	   prep2=conn.prepareStatement("select count(*) as num1 from enrolment where rId=?");
//		    	   prep2.setString(1,_rid);
//		    	   rs2=prep2.executeQuery();
//		    	   rs2.next();
//		    	   if(Integer.parseInt(rs2.getString("num1"))==0) {
//		    		   prep4=conn.prepareStatement("delete from Room where rId=?");
//				       prep4.setString(1, _rid);
//				       prep4.executeUpdate();
//		    		   
//		    	   }
			       flag=1;
			       }
			
			catch (SQLException e1) {
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
					flag=3;
					System.out.println("数据库语句语法出现错误！\n");
					e.printStackTrace();
				}
		DataAccess.closeConnection(prep1, conn);
			}
				
				return flag;
			}
	
	
}
