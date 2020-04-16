package cn.edu.lingnan.test;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.util.DataAccess;
public class BlobClobTest {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement prep=null;
		Statement stat=null;
		ResultSet rs=null;
	try {
		conn=DataAccess.getConnection();
		 //-----Blob存-----
//		File f=new File("c:\\p1.jpg");
//	    FileInputStream fis=new FileInputStream(f);
//	    prep=conn.prepareStatement("insert into bbtable values(?,?);");
//	    prep.setInt(1, 1);
//	    prep.setBinaryStream(2, fis, (int)f.length());
//	    prep.executeUpdate();
		//-----取------
//		stat=conn.createStatement();
//		rs=stat.executeQuery("select * from blobtable where id =1");
//		rs.next();
//        InputStream is= rs.getBinaryStream("binaryfile");
//        File f=new File("c:\\p111.jpg");
//        FileOutputStream fos=new FileOutputStream(f);
//        
//        int i=0;
//        while ((i=is.read())!=-1) {
//				fos.write(i);
//			}
		//-------Clob存------
//		File f=new File("c:\\a.txt");
//	    FileInputStream fis=new FileInputStream(f);
//	    prep=conn.prepareStatement("insert into cbtable values(?,?);");
//	    prep.setInt(1, 1);
////	    prep.setBinaryStream(2, fis, (int)f.length());
//	    prep.setAsciiStream(2, fis, (int)f.length());
//	    prep.executeUpdate();
//		
		//-----取------
		stat=conn.createStatement();
		rs=stat.executeQuery("select * from cbtable where id =1");
		rs.next();
        InputStream is= rs.getBinaryStream("textfile");
        File f=new File("c:\\a111.txt");
        FileOutputStream fos=new FileOutputStream(f);
        
        int i=0;
        while ((i=is.read())!=-1) {
				fos.write(i);
			}
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DataAccess.closeConnection(prep, conn);
		
	}

	}

}
