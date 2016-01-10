package com.backend.domain.model.type;


public enum CommunicationEventType implements IntegerEnumType<CommunicationEventType> {
	NEW_CUSTOMER_SIGNUP(1);
	
	private int code;

    private CommunicationEventType(int c) {
        code = c;
    }

    @Override
    public int getCode() {
        return code;
    }

}