package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dao.CustomerDAO;
import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.util.DataAccess;

public class Customertest {

	public static void main(String[] args) {
		Customer c=new Customer();
//      查找客人名字和密码
		CustomerDAO cd=new CustomerDAO();
		//删除
//		cd.deleteCustomer("c06");
//		System.out.println(cd.findCustomerByNameAndPassword("zhangsan1", "121"));
//		更新
//		c.setcId("c010");
//		c.setcName("zhangsan1");
//		c.setcPassword("121");
//		c.setcSuper(1);
//		System.out.println(cd.updateCustomer(c));
		
//		查找全部客人
		Vector<Customer> v=new Vector<Customer>();
		cd.findAllCustomer();
		System.out.println(v.size());
//		
//		插入
//		Customer c=new Customer();
//		c.setcId("c11");
//		c.setcName("zhangsan9");
//		c.setcPassword("12109");
//		c.setcSuper(1);
//		System.out.println(cd.insertInfoToCustomer(c));
		//--------------------------2019-3-19
//		 Connection conn=null;
//			Statement stat=null;
//			ResultSet rs=null;
//			boolean flag=false;
//		try {
//			conn=DataAccess.getConnection();
//		     stat=conn.createStatement
//		    (ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//		     //-----2---
//		     rs=stat.executeQuery("select * from customer");
		   //对结果进行操作，所以不用sql语句即可实现数据库的查询和更改
//		     System.out.println(rs.isBeforeFirst());
//		     rs.first();
//		     System.out.println(rs.isBeforeFirst());
//		     rs.last();
//		     System.out.println(rs.isLast());
//		     System.out.println(rs.getString("cName"));
//		     rs.absolute(3);
//		     System.out.println(rs.getString("cName"));
//		     rs.relative(2);
//		     System.out.println(rs.getString("cName"));
//           System.out.println(rs.getRow());
		     //-----3-----更改
//		     rs.moveToInsertRow();
//		     rs.updateString("cId", "c12");
//		     rs.updateString("cName", "zhangsan12");
//		     rs.updateString("cPassword", "1212");
//		     rs.updateInt("cSuper", 1);
//		     rs.insertRow();
		     
//		     rs.absolute(12);
//		     rs.updateString("cPassword","12121");
//		     rs.updateRow();
		     
//		     rs.absolute(12);
//		     rs.deleteRow();
		    
			
			
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DataAccess.closeConnection(rs, stat, conn);
//			
//		}
///------------------------------------------------------------------------

	}

}
