package cn.edu.lingnan.test;

import java.util.Vector;


import cn.edu.lingnan.dao.RoomDAO;
import cn.edu.lingnan.dto.Room;

public class Roomtest {
	public static void main(String[] args) {
		
		
		RoomDAO rd=new RoomDAO();
//		System.out.println(rd.findRoomByNameAndPassword("danren", "r01"));
//		
		
		
//		Vector<Room> v=new Vector<Room>();
//		v=rd.findAllRoom();
//		System.out.println(v.size());
		//删除
//		System.out.println(rd.deleteRoom("r10"));
		//更新
		Room r=new Room();
		r.setrId("r12");
		r.setrName("siren");
		r.setrPrice(444);
		r.setrStock(4);
		System.out.println(rd.updateRoom(r));
//	--------------------------------------------	
//		Room r=new Room();
//		r.setrId("r05");
//		r.setrName("danren");
//		r.setrStock(5);
//		r.setrPrice(555);
//		System.out.println(rd.insertInfoToRoom(r));
//		
		
	}

}
