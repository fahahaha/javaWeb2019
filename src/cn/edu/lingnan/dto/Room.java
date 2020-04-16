package cn.edu.lingnan.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.lingnan.util.DataAccess;

public class Room {
	private String rId ;
	private String rName;
	private int rStock;
	private int rPrice;
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public int getrStock() {
		return rStock;
	}
	public void setrStock(int rStock) {
		this.rStock = rStock;
	}
	public int getrPrice() {
		return rPrice;
	}
	public void setrPrice(int rPrice) {
		this.rPrice = rPrice;
	}
}
