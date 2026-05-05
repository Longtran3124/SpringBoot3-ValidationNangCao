package com.tdl.SpringBoot.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "uncategorized error"),
    INVALID_KEY(1001, "invalid message key"),
    USER_EXISTED(1002, "user existed"),
    USERNAME_INVALID(1003, "username must be at least 3 character"),
    INVALID_PASSWORD(1004, "password must be at least 8 character"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
