package com.backend.domain.model.repository;


import org.springframework.data.repository.CrudRepository;

import com.backend.domain.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	@SuppressWarnings("unchecked")
	User save(User user); 
	User findByEmail(String email);
	User findByUserName(String userName);
}
