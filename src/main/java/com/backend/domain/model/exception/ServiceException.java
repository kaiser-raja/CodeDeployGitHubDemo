package com.backend.domain.model.exception;

public class ServiceException extends DomainException {
    private static final long serialVersionUID = -5337694827535104098L;

    public ServiceException(String ms) {
        super(ms);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException() {
        super();
    }
}