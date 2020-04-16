package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Preparetest {

	public static void main(String[] args) {
			 Connection conn=null;
				//Statement stat=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				
			try {
				Class.forName("com.mysql.jdbc.Driver");
			     conn=DriverManager.getConnection
			    ("jdbc:mysql://localhost:3306/hotel", "root", "123456");
				 //stat=conn.createStatement();
				 //String sql="select * from customer where cName='"+_name+"'and cPassword='"+_password+"' ";
				 //rs=stat.executeQuery(sql);
//				 if(rs.next()) {
//					 flag=true;
//				 }
			//使用preparestatement可提高可读性和安全性，下面是单个插入
//			     prep=conn.prepareStatement("insert into customer values(?,?,?,?)");
//			     prep.setString (1,"c05");
//			     prep.setString(2, "zhangsan5");
//			     prep.setString(3, "125");
//			     prep.setInt(4, 2);
//			     prep.executeUpdate();
			 //preparestatement多个插入,增加时候需要使用addbatch和executebatch（可以试一试循环插入）
			     prep=conn.prepareStatement("insert into customer values(?,?,?,?)");
			     prep.setString (1,"c06");
			     prep.setString(2, "zhangsan6");
			     prep.setString(3, "126");
			     prep.setInt(4, 2);
			     prep.addBatch();
			     
			     prep.setString (1,"c07");
			     prep.setString(2, "zhangsan7");
			     prep.setString(3, "127");
			     prep.setInt(4, 2);
			     prep.addBatch();
			     
			     prep.setString (1,"c08");
			     prep.setString(2, "zhangsan8");
			     prep.setString(3, "128");
			     prep.setInt(4, 2);
			     prep.addBatch();
			     //循环没过
//			     prep=conn.prepareStatement("insert into customer values(?,?,?,?)");
//			     for(int i=10;i<=11;i++)
//			     {
//			     String s1="c0'"+i+"'";
//			     String s2="zhangsan'"+i+"'";
//			     String s3="12'"+i+"'";
//			   
//			     prep.setString (1,s1);
//			     prep.setString(2,s2 );
//			     prep.setString(3,s3 );
//			     prep.setInt(4, 2);
//			     prep.addBatch();
//			     
//			     }
			     
			     int []a=prep.executeBatch();
			     for(int b:a) {
			    	 System.out.println(b);
			     }
			     
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)
					rs.close();
					if(prep!=null)
					prep.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}

		
		
	}

}
