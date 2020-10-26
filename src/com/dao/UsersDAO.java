package com.dao;

import com.model.User;

public interface UsersDAO {
	int Register(User users);

	User login(String username,String password);
	
	int ResetPassword(String username,String password);

}
