package com.backend.domain.model.type;


public enum UserStatusType implements IntegerEnumType<UserStatusType> {
	ACTIVE(1),
	DELETED(2),
	DISABLED(3),
	INACTIVE(4),
	LOCKED(5),
	PENDING(6),
	REJECTED(7),
	VERIFICATION_PENDING(8);
	
	private int code;

    private UserStatusType(int c) {
        code = c;
    }

    @Override
    public int getCode() {
        return code;
    }

}