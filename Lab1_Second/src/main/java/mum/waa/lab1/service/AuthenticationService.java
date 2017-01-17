package mum.waa.lab1.service;

import mum.waa.lab1.model.User;

public class AuthenticationService {
	
	public boolean authenticateLogin(User user){
		if(user.getUsername().equals("admin") && user.getPassword().equals("test123")){
			return true;
		}else{
			return false;
		}
	}

}
