package com.backend.interfaces.facade;

import com.backend.domain.model.exception.FacadeException;
import com.backend.interfaces.json.model.UserModel;
import com.backend.interfaces.json.model.UserRegistrationModel;

public interface UserServiceFacade {
	 public UserModel register(UserRegistrationModel userRegistrationModel, String userType) throws FacadeException;
}
