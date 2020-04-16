package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Room;
import cn.edu.lingnan.util.DataAccess;

public class RoomDAO {

	public boolean findRoomByNameAndPassword(String _name,String _password){
		 Connection conn=null;
			//Statement stat=null;
		 PreparedStatement prep=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
			   conn=DataAccess.getConnection();
//			 stat=conn.createStatement();
//			 String sql="select * from Room where rName='"+_name+"'and rId='"+_password+"' ";
//			 rs=stat.executeQuery(sql);
		     
		     prep=conn.prepareStatement("select * from Room where rName=? and rId=?");
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
//用于web
	public Vector<Room> AllRoom(){
		Vector<Room> v=new Vector<Room>();
		 Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
			   conn=DataAccess.getConnection();
			 stat=conn.createStatement();
			 String sql="select * from Room ";
			 rs=stat.executeQuery(sql);
			 while(rs.next()) {
				 Room r=new Room();
				r.setrId(rs.getString("rId"));
				r.setrName(rs.getString("rName"));
				r.setrStock(rs.getInt("rStock"));
				r.setrPrice(rs.getInt("rPrice"));
				v.add(r);
				flag=true;
			 }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
	DataAccess.closeConnection(rs, stat, conn);
		}
		return v;
	}
//用于testDAO封面
	public Vector<Room> findAllRoom(){
		Vector<Room> v=new Vector<Room>();
		 Connection conn=null;
			Statement stat=null;
			ResultSet rs=null;
			boolean flag=false;
		try {
			   conn=DataAccess.getConnection();
			 stat=conn.createStatement();
			 String sql="select * from Room ";
			 rs=stat.executeQuery(sql);
				System.out.println("房间编号 | 房间型号 | 房间库存 | 房间价格 | ");
			 while(rs.next()) {
				 Room r=new Room();
				r.setrId(rs.getString("rId"));
				r.setrName(rs.getString("rName"));
				r.setrStock(rs.getInt("rStock"));
				r.setrPrice(rs.getInt("rPrice"));
			
				System.out.println(r.getrId()+"     |  "+r.getrName()+"  |     "+r.getrStock()+"   | "+r.getrPrice()+" | ");
				System.out.println("---------------------------------------");
				v.add(r);
			 }
		
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
	DataAccess.closeConnection(rs, stat, conn);
			
		}

		
		
		return v;
	}
	
	//插入房间号
	public int insertInfoToRoom(Room r) {
		int flag=0;
		
		String rId=r.getrId();
		String rName=r.getrName();
		int rStock=r.getrStock();
		int rPrice=r.getrPrice();
		
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
		     
//		     //假设客人号不存在
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
//		    	 return flag;
//		     }
		     
		     //假设客人号和房间号都存在
		     prep=conn.prepareStatement("insert into room values(?,?,?,?)");
		     prep.setString(1, rId);
		     prep.setString(2, rName);
		     prep.setInt(3, rStock);
		     prep.setInt(4, rPrice);
		     prep.executeUpdate();
		     flag=1;
		
			
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			flag=4;
		}finally {
			DataAccess.closeConnection(rs, prep, conn);
			
		}

		return flag;
	}
	public int updateRoom(Room r) {
		int flag=0;
		String rId=r.getrId();
		String rName=r.getrName();
		int rPrice=r.getrPrice();
		int rStock=r.getrStock();
		
		Connection conn=null;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
	try {
		   conn=DataAccess.getConnection();
		 //检测id是否存在
		   prep1=conn.prepareStatement("select count(*) as num from room where rId=?");
			prep1.setString(1, rId);
			rs1=prep1.executeQuery();
			rs1.next();
			if(Integer.parseInt(rs1.getString("num"))==0) {
				System.out.println("该房间编号不存在！\n");
				flag=2;
				return flag;
			}
			//----------------------------------------------
		prep=conn.prepareStatement("update Room set rName=?,rPrice=?,rStock=? where rId=?");
		prep.setString(1, rName);
		prep.setInt(2, rPrice);
		prep.setInt(3, rStock);
		prep.setString(4, rId);
		prep.executeUpdate();
		flag=1;
	
		
	} 
	catch (SQLException e) {
		flag=3;
		System.out.println("数据库语句语法出现错误！");
		e.printStackTrace();
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
	public int deleteRoom(String _rid) {
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
		   prep5=conn.prepareStatement("select count(*) as numrid from Room where rId=?");
		   prep5.setString(1, _rid);
		   rs5=prep5.executeQuery();
		   rs5.next();
		   if(Integer.parseInt(rs5.getString("numrid"))==0) {
			   System.out.println("该房间编号不存在！\n");
			   flag=2;
			   return flag;
		   }
		   //-----------------------------
		   prep2=conn.prepareStatement("select * from enrolment where rid=?");
		   prep2.setString(1, _rid);
	       rs2=prep2.executeQuery();
	       Vector<String> v=new Vector<String>();
	       while(rs2.next()) {
	    	   //出现的rid ，再判断是否只有上面的cid一个人选了，若等于1，则可以删除Room
	    	   prep3=conn.prepareStatement("select count(*) as num from enrolment where cId=?");
	    	   prep3.setString(1,rs2.getString("rId"));
	    	   rs3=prep3.executeQuery();
	    	   
	    	   rs3.next();
	    	   //System.out.println(rs2.getString("rId")+"     "+rs3.getString("num"));
	    	   if(Integer.parseInt(rs3.getString("num"))==1) {
	    		   v.add(rs2.getString("cId"));
	    		   //不能先删房间表，出现外键错误
//	    		   prep4=conn.prepareStatement("delete from room where rid=?");
//	    		   prep4.setString(1, rs2.getString("rId"));
//	    		   prep4.executeUpdate();
	    	   }
	       }
	       conn.setAutoCommit(false);
		   //先删除登记表，再删除客人。
		   prep1=conn.prepareStatement("delete from enrolment where rId=?");
		   prep1.setString(1, _rid);
	       prep1.executeUpdate();
		   //删除房间----------------------------
		   
	       prep=conn.prepareStatement("delete from room where rId=?");
	       prep.setString(1, _rid);
	       prep.executeUpdate();
		//删除客人
	       for(String a:v) {
	    	   prep4=conn.prepareStatement("delete from customer where cId=?");
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
			System.out.println("数据库语句语法出现错误！");
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
	//房间库存加1
	public int addRoom(String rid) {
		int flag=0;
		
		String rId=rid;
		
		
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

		     
		     //假设客人号和房间号都存在
		     prep=conn.prepareStatement("update room set rStock=rStock+1 where rId=?");
		     prep.setString(1, rId);
		     prep.executeUpdate();
		     flag=1;
		
			
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			flag=4;
		}finally {
			DataAccess.closeConnection(rs, prep, conn);
			
		}

		return flag;
	}
}
