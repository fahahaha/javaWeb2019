package cn.edu.lingnan.test;

import java.util.Vector;

import cn.edu.lingnan.dao.EnrolmentDAO;
import cn.edu.lingnan.dto.Enrolment;

public class Enrolmentest {

	public static void main(String[] args) {
		Enrolment e=new Enrolment();
		
		EnrolmentDAO ed=new EnrolmentDAO();
//		System.out.println(ed.findEnrolmentByNameAndPassword("c01", "r01"));
		
		
//		Vector<Enrolment> v=new Vector<Enrolment>();
//		v=ed.findAllEnrolment();
//		System.out.println(v.size());
		//删除

//		System.out.println(ed.deleteEnrolment("c09", "r10"));
		//更新
		e.setcId("c10");
		e.setrId("r01");
		e.seteCheck("checkin");
		System.out.println(ed.updateEnrolment(e));
//		Enrolment e=new Enrolment();
//		e.setcId("c07");
//		e.setrId("r04");
//		e.seteCheck("checkin");
//		System.out.println(ed.insertInfoToEnrolment(e));
	}

}
