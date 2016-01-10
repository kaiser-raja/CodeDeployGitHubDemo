package com.backend.domain.model.exception;

public class FactoryException extends DomainException {
    private static final long serialVersionUID = -3955538101712748713L;

    public FactoryException(String ms) {
        super(ms);
    }

    public FactoryException() {
        super();
    }
}