package mum.waa.lab3.repository;

import mum.waa.lab3.domain.User;

public interface UserRepository {
	public boolean authenticate(User user);
}
