package com.mili.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author user
 *
 */
public class DbUtil {
	private String dbbUri="jdbc:mysql://127.0.0.1:3306/data?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private String dbUserName="root";
	private String dbPassword="ray39456815";
	private String jdbcName="com.mysql.cj.jdbc.Driver";

	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbbUri, dbUserName, dbPassword);
		return con;
	}
	
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
}

