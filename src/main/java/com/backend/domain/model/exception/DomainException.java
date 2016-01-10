package com.backend.domain.model.exception;

public class DomainException extends Exception {
	private static final long serialVersionUID = 3448016988480545666L;

    public DomainException(String ms, Exception e) { // NO_UCD (use default)
        super(ms, e);
    }

    public DomainException(String ms) { // NO_UCD (use default)
        super(ms);
    }

    public DomainException(Exception e) { // NO_UCD (use default)
        super(e);
    }

    public DomainException() {
        super();
    }
}
