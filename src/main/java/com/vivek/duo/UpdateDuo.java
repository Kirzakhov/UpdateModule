package com.vivek.duo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateDuo {
		String url = "jdbc:mysql://localhost:3306/vivek";
		String un = "root";
		String up = "0000";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		public int update(String name, String pass) {
		int i = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,un,up);
			String s = "select * from login where uname=?";
			pst = con.prepareStatement(s);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()) {
				String q = "update login set upass=? where uname=?";
				pst = con.prepareStatement(q);
				pst.setString(1, pass);
				pst.setString(2, name);
				i = pst.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
