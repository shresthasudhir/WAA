package mum.waa.lab3.repository;

import org.springframework.stereotype.Repository;

import mum.waa.lab3.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Override
	public boolean authenticate(User user){
		if("admin".equals(user.getUsername()) && "test123".equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}
}
