package com.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UsersDAO;
import com.model.User;
import com.utility.ConnectionUtility;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public int Register(User users) {
		try {
			PreparedStatement st1=ConnectionUtility.getCon().prepareStatement("INSERT INTO User values(?,?,?,?,?,?,?,?)");
			st1.setInt(1,users.getUser_id());
			st1.setString(2,users.getFirst_name());
			st1.setString(3,users.getLast_name());
			st1.setString(4,users.getUsername());
			st1.setString(5,users.getPassword());
			st1.setString(6,users.getEmail_id());
			st1.setString(7,users.getContact());
			st1.setString(8,users.getAddress());
			return st1.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User login(String username, String password) {
		try {
			User u=new User();
			String sqlShow = "Select * from user "
	                + "WHERE username = ?"
					+"And password=?";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlShow);
			st1.setString(1,username);
			st1.setString(2, password);
			ResultSet rs1=st1.executeQuery();
			while(rs1.next()) {
				u.setUser_id(rs1.getInt(1));
				u.setFirst_name(rs1.getString(2));
				u.setLast_name(rs1.getString(3));
				u.setUsername(rs1.getString(4));
				u.setPassword(rs1.getString(5));
				u.setEmail_id(rs1.getString(6));
				u.setContact(rs1.getString(7));
				u.setAddress(rs1.getString(8));
			}
			return u;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int ResetPassword(String username, String password) {
		try {
			String sqlShow = "Select password from user " + "WHERE username = ?";
			String oldPassword = "";
			PreparedStatement st1 = ConnectionUtility.getCon().prepareStatement(sqlShow);
			st1.setString(1, username);
			ResultSet rs = st1.executeQuery();
			if (rs.next()) {
				oldPassword = rs.getString("password");
			}

			System.out.println(oldPassword);
			System.out.println(password);
			if (oldPassword.equals(password)) {
				System.out.println("Old and new Password are Same");
				return 0;
			} else {
				// String passwordUpdate = "Update user" + "set 'password'=?" + "where
				// 'username'=?";
				PreparedStatement st2 = ConnectionUtility.getCon()
						.prepareStatement("UPDATE `user` SET `password` = ? WHERE `user`.`username` = ?");
				st2.setString(1, password);
				st2.setString(2, username);
				return st2.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}
	
	
	

}
