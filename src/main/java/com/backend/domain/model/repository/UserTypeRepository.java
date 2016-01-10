package com.backend.domain.model.repository;


import org.springframework.data.repository.CrudRepository;

import com.backend.domain.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
	UserType findIdByName(String name);
}
