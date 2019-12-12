package com.drools_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	public static boolean connection(String sql) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			 conn =
					 DriverManager.getConnection("jdbc:sqlserver://[dbserver]:1433;DatabaseName=[dbname]",
			 "devplogin", "devplogin");
			if (conn != null) {
				System.out.println("获得连接成功!");
			}
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("descript"));
			}
		} catch (Exception e) {
			System.out.println("查询失败!");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("连接已关闭");
		}
		return true;
	}
}
