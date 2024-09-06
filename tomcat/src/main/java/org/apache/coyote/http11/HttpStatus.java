package org.apache.coyote.http11;

public enum HttpStatus {

    OK(200, "OK"),
    CREATED(201, "Created"),
    FOUND(302, "Found"),
    UNAUTHORIZED(401, "Unauthorized");

    private final int code;
    private final String value;

    HttpStatus(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
