package org.apache.coyote.http11.response;

import org.apache.coyote.http11.component.HttpStatus;

public class StatusLine {

    private static final String STATUS_LINE_DELIMITER = " ";

    private final String httpVersion;
    private HttpStatus httpStatus;

    public StatusLine() {
        this("HTTP/1.1", HttpStatus.OK);
    }

    public StatusLine(HttpStatus httpStatus) {
        this("HTTP/1.1", httpStatus);
    }

    private StatusLine(String httpVersion, HttpStatus httpStatus) {
        this.httpVersion = httpVersion;
        this.httpStatus = httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getStatusLineMessage() {
        return String.join(
                STATUS_LINE_DELIMITER,
                httpVersion,
                String.valueOf(httpStatus.getCode()),
                httpStatus.getValue(),
                ""
        );
    }
}
