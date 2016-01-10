package com.backend.domain.model.exception;

public class FacadeException extends DomainException {
    private static final long serialVersionUID = 9188025448573092720L;
    private static String facadeExceptionMessage;
    
    public FacadeException(String ms, Exception e) {
        super(ms, e);
    }

    public FacadeException(String ms) {
        super(ms);
    	facadeExceptionMessage = ms;
    }

    public FacadeException(Exception e) {
        super(e);
    }

    public FacadeException() {
        super();
    }

	public String getFacadeExceptionMessage() {
		return facadeExceptionMessage;
	}

	public void setFacadeExceptionMessage(String facadeExceptionMessage) {
		this.facadeExceptionMessage = facadeExceptionMessage;
	}
    
    
}