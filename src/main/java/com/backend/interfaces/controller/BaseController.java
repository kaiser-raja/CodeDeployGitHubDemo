package com.backend.interfaces.controller;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public abstract class BaseController {
	private static final String RESULTS = "results";
    private static final String ROWS = "rows";
    private static final String SIZE = "size";
    private static final String SUCCESS = "success";
    private static final String SUCCESS_MESSAGE = "Operation completed successfully.";
    private static final String FAILURE_MESSAGE = "failureMessage";
    
    
    protected Map<String, Object> createModelMap(Object row) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, true);
        modelMap.put(ROWS, row != null ? singletonList(row) : emptyList());
        modelMap.put(RESULTS, row != null ? 1 : 0);
        return modelMap;
    }
    
    protected Map<String, Object> createFailedModelMap(String msg) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put(SUCCESS, false);
        modelMap.put(FAILURE_MESSAGE, msg);
        return modelMap;
    }
}
