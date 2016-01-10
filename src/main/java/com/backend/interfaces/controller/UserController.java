package com.backend.interfaces.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.domain.model.exception.FacadeException;
import com.backend.interfaces.facade.UserServiceFacade;
import com.backend.interfaces.json.model.UserModel;
import com.backend.interfaces.json.model.UserRegistrationModel;
import com.wordnik.swagger.annotations.Api;


@Api(value = "User", description = "User Operations")
@RestController
@RequestMapping("user/")
public class UserController extends BaseController {
	
   @Autowired
   UserServiceFacade userServiceFacade;

    @RequestMapping(value = "register.json", method = RequestMethod.POST)
    public Map<String, Object> register(@RequestBody UserRegistrationModel userRegistrationModel, @RequestParam(value="userType", required=true) String userType) {
    	UserModel userModel = new UserModel();
    	
    	try {
    		userModel = userServiceFacade.register(userRegistrationModel, userType);
    		return createModelMap(userModel);
       } catch (FacadeException e) {
    	   return createFailedModelMap(e.getFacadeExceptionMessage());
       }
    }   
}