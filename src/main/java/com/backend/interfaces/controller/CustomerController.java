package com.backend.interfaces.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.domain.model.exception.FacadeException;
import com.backend.interfaces.facade.CustomerServiceFacade;
import com.backend.interfaces.json.model.CustomerModel;
import com.backend.interfaces.json.model.CustomerSignupModel;


@RestController
@RequestMapping("customer/")
public class CustomerController extends BaseController {
	
   @Autowired
   CustomerServiceFacade customerServiceFacade;

    @RequestMapping(value = "signup.json")
    public Map<String, Object> signup(@RequestBody CustomerSignupModel customerSignupModel) {
    	CustomerModel customerModel = new CustomerModel();
    	
    	try {
    		customerModel = customerServiceFacade.signup(customerSignupModel);
    		return createModelMap(customerModel);
       } catch (FacadeException e) {
    	   return createFailedModelMap(e.getFacadeExceptionMessage());
       }
    }
}