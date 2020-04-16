package cn.edu.lingnan.test;

import java.util.Scanner;

import cn.edu.lingnan.dao.CustomerDAO;
import cn.edu.lingnan.dao.EnrolmentDAO;
import cn.edu.lingnan.dao.RoomDAO;
import cn.edu.lingnan.dto.Customer;
import cn.edu.lingnan.dto.Enrolment;
import cn.edu.lingnan.dto.Room;

public class DAOTest {

	public static CustomerDAO cd=new CustomerDAO();
	public static RoomDAO rd=new RoomDAO();
	public static EnrolmentDAO ed=new EnrolmentDAO();
	public static void main(String[] args) {
		meun();
	}
	public static void meun() {
		Scanner scanf=new Scanner(System.in);
		System.out.println("---------------------------- 欢迎您来到宾馆客房系统----------------------------------------");
		System.out.println("------------------------请选择相应的数字进行测试，这里是主菜单------------------------------");
		System.out.println("------------1.查看信息-------2.增加信息-------3.修改信息------4.删除信息------5.退出系统------------");
		System.out.println("\n");
		while (scanf.hasNextLine()) {
			String str=scanf.nextLine();
			if(str.equals("1")) {
				find();
			}else if(str.equals("2")) {
				insert();
			}else if(str.equals("3")) {
				update();
			}else if(str.equals("4")) {
				delete();
			}else if(str.equals("5")) {
				System.exit(0);
			}else {
				System.out.println("您输入的信息有误！请重新输入！\n");

			}
		}
	}
	public static void find () {
		System.out.println("------------------------请选择相应的数字进行测试，这里 查询 二级菜单------------------------------");
		System.out.println("------------1.查询客人-------2.查询房间-------3.查询入住信息------4.返回上一级------5.退出系统------------");
		System.out.println("\n");
		Scanner scanf=new Scanner(System.in);
		while (scanf.hasNextLine()) {
			String str=scanf.nextLine();
			if(str.equals("1")) {
				cd.findAllCustomer();
				find();
			}else if(str.equals("2")) {
				rd.findAllRoom();
				find();
			}else if(str.equals("3")) {
				ed.findAllEnrolment();
				find();
			}else if(str.equals("4")) {
				meun();
			}else if(str.equals("5")) {
				System.exit(0);
			}else {
				System.out.println("您输入的信息有误！请重新输入！\n");

			}
		}
	}
	public static void insert () {
		System.out.println("------------------------请选择相应的数字进行测试，这里 增加 二级菜单------------------------------");
		System.out.println("------------1.增加客人-------2.增加房间-------3.增加入住信息------4.返回上一级------5.退出系统------------");
		System.out.println("\n");
		
		Scanner scanf=new Scanner(System.in);
		while (scanf.hasNextLine()) {
			String str=scanf.nextLine();
			if(str.equals("1")) {
				Customer c=new Customer();
				System.out.println("请输入待增加客人编号：\n");
				Scanner cid=new Scanner(System.in);
				String str1=cid.nextLine();
				c.setcId(str1);
				System.out.println("请输入待增加客人姓名：\n");
				Scanner cname=new Scanner(System.in);
				String str2=cname.nextLine();
				c.setcName(str2);
				System.out.println("请输入待增加客人密码：\n");
				Scanner password=new Scanner(System.in);
				String str3=password.nextLine();
				c.setcPassword(str3);
				System.out.println("请输入待增加权限：\n");
				Scanner csuper=new Scanner(System.in);
				int str4=csuper.nextInt();
				c.setcSuper(str4);
				int cn=cd.insertInfoToCustomer(c);
				if(cn==1) {
					System.out.println("插入成功！\n");
				}
				else {
					System.out.println("插入失败！\n");
				}
				insert ();
			}else if(str.equals("2")) {
				Room r=new Room();
				System.out.println("请输入待增加房间编号：\n");
				Scanner rid=new Scanner(System.in);
				String str1=rid.nextLine();
				r.setrId(str1);
				System.out.println("请输入待增加房间型号：\n");
				Scanner rname=new Scanner(System.in);
				String str2=rname.nextLine();
				r.setrName(str2);
				System.out.println("请输入待增加房间库存：\n");
				Scanner rStock=new Scanner(System.in);
				int str3=rStock.nextInt();
				r.setrStock(str3);
				System.out.println("请输入待增加房间价格：\n");
				Scanner rprice=new Scanner(System.in);
				int str4=rprice.nextInt();
				r.setrPrice(str4);
				int cn=rd.insertInfoToRoom(r);
				if(cn==1) {
					System.out.println("插入成功！\n");
				}
				else {
					System.out.println("插入失败！\n");
				}
				insert ();
			}else if(str.equals("3")) {
				Enrolment e=new Enrolment();
				System.out.println("请输入待增加客人编号：\n");
				Scanner cid=new Scanner(System.in);
				String str1=cid.nextLine();
				e.setcId(str1);
				System.out.println("请输入待增加房间编号：\n");
				Scanner rid=new Scanner(System.in);
				String str2=rid.nextLine();
				e.setrId(str2);
				System.out.println("请输入待增加房间状态：\n");
				Scanner echeck=new Scanner(System.in);
				String str3=echeck.nextLine();
				e.seteCheck(str3);
				int cn=ed.insertInfoToEnrolment(e);
				if(cn==1) {
					System.out.println("插入成功！\n");
				}else if(cn==2){
					System.out.println("插入失败！客人编号已存在！\n");
				}else if(cn==3){
					System.out.println("插入失败！房间编号已存在！\n");
				}else {
					System.out.println("插入失败！其他原因！\n");
				}
				insert ();
			}else if(str.equals("4")) {
				meun();
			}else if(str.equals("5")) {
				System.exit(0);
			}else {
				System.out.println("您输入的信息有误！请重新输入！\n");

			}
		}
		
	}
	public static void update () {
		System.out.println("------------------------请选择相应的数字进行测试，这里 更新 二级菜单------------------------------");
		System.out.println("------------1.更新客人-------2.更新房间-------3.更新入住信息------4.返回上一级------5.退出系统------------");
		System.out.println("\n");
		Customer c=new Customer();
		Room r=new Room();
		Enrolment e=new Enrolment();

		Scanner scanf=new Scanner(System.in);
		while (scanf.hasNextLine()) {
			String str=scanf.nextLine();
			if(str.equals("1")) {
				System.out.println("请输入要更新的客人编号：\n");
				Scanner cid=new Scanner(System.in);
				String str1=cid.nextLine();
				c.setcId(str1);
				System.out.println("请输入待更新客人姓名：\n");
				Scanner cname=new Scanner(System.in);
				String str2=cname.nextLine();
				c.setcName(str2);
				System.out.println("请输入待更新客人密码：\n");
				Scanner password=new Scanner(System.in);
				String str3=password.nextLine();
				c.setcPassword(str3);
				System.out.println("请输入待更新权限：\n");
				Scanner csuper=new Scanner(System.in);
				int str4=csuper.nextInt();
				c.setcSuper(str4);
				if(cd.updateCustomer(c)==1) {
					System.out.println("更新成功！\n");
				}else {
					System.out.println("更新失败！\n");

				}
				update ();
			}else if(str.equals("2")) {
				System.out.println("请输入要更新的房间编号：\n");
				Scanner rid=new Scanner(System.in);
				String str1=rid.nextLine();
				r.setrId(str1);
				System.out.println("请输入待更新房间型号：\n");
				Scanner rname=new Scanner(System.in);
				String str2=rname.nextLine();
				r.setrName(str2);
				System.out.println("请输入待更新房间库存：\n");
				Scanner rStock=new Scanner(System.in);
				int str3=rStock.nextInt();
				r.setrStock(str3);
				System.out.println("请输入待更新房间价格：\n");
				Scanner rprice=new Scanner(System.in);
				int str4=rprice.nextInt();
				r.setrPrice(str4);
				if(rd.updateRoom(r)==1) {
					System.out.println("更新成功！\n");
				}else {
					System.out.println("更新失败！\n");

				}
				update ();
			}else if(str.equals("3")) {
				System.out.println("请输入要更新的客人编号：\n");
				Scanner cid=new Scanner(System.in);
				String str1=cid.nextLine();
				e.setcId(str1);
				System.out.println("请输入待更新房间编号：\n");
				Scanner rid=new Scanner(System.in);
				String str2=rid.nextLine();
				e.setrId(str2);
				System.out.println("请输入待更新房间状态：\n");
				Scanner echeck=new Scanner(System.in);
				String str3=echeck.nextLine();
				e.seteCheck(str3);			
				if(ed.updateEnrolment(e)==1) {
					System.out.println("更新成功！\n");
				}else {
					System.out.println("更新失败！\n");

				}
				update ();
			}else if(str.equals("4")) {
				meun();
			}else if(str.equals("5")) {
				System.exit(0);
			}else {
				System.out.println("您输入的信息有误！请重新输入！\n");

			}
		}
}
	public static void delete () {
		System.out.println("------------------------请选择相应的数字进行测试，这里 删除 二级菜单------------------------------");
		System.out.println("------------1删除客人-------2.删除房间-------3.删除入住信息------4.返回上一级------5.退出系统------------");
		System.out.println("\n");
		Scanner scanf=new Scanner(System.in);
		while (scanf.hasNextLine()) {
			String str=scanf.nextLine();
			if(str.equals("1")) {
				System.out.println("请输入您要删除的客人编号：\n");
				Scanner cid=new Scanner(System.in);
				String str1=cid.nextLine();
				if(cd.deleteCustomer(str1)==1) {
					System.out.println("删除成功！\n");
				}else {
					System.out.println("删除失败！\n");

				}
				delete ();
			}else if(str.equals("2")) {
				System.out.println("请输入您要删除的房间编号：\n");
				Scanner rid=new Scanner(System.in);
				String str1=rid.nextLine();
				if(rd.deleteRoom(str1)==1) {
					System.out.println("删除成功！\n");
				}else {
					System.out.println("删除失败！\n");

				}
				delete ();
			}else if(str.equals("3")) {
				System.out.println("请输入您要删除的入住登记表：\n");
				System.out.println("请输入客人编号：\n");
				Scanner cid=new Scanner(System.in);
				String str1=cid.nextLine();
				System.out.println("请输入房间编号：\n");
				Scanner rid=new Scanner(System.in);
				String str2=rid.nextLine();
				if(ed.deleteEnrolment(str1, str2)==1) {
					System.out.println("删除成功！\n");
				}else {
					System.out.println("删除失败！\n");

				}
				delete ();
			}else if(str.equals("4")) {
				meun();
			}else if(str.equals("5")) {
				System.exit(0);
			}else {
				System.out.println("您输入的信息有误！请重新输入！\n");

			}
		}
}

}
