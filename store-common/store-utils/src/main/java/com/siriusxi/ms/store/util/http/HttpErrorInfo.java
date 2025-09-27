package com.siriusxi.ms.store.util.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.http.HttpStatus;
import java.util.Objects;

import java.time.ZonedDateTime;

/**
 * Record <code>HttpErrorInfo</code> which encapsulate all HTTP errors sent to client.
 *
 * @implNote Since it is a record and not normal POJO, so it needs some customizations
 * to be serialized to JSON and this is done with method
 * <code>GlobalConfiguration.jacksonCustomizer()</code>.
 *
 * @see java.lang.Record
 * @see com.siriusxi.ms.store.util.config.GlobalConfiguration
 * @author mohamed.taman
 * @version v4.6
 * @since v0.1
 */
public class HttpErrorInfo {
    private final HttpStatus httpStatus;
    private final String message;
    private final String path;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private final ZonedDateTime timestamp;

    public HttpErrorInfo(
            HttpStatus httpStatus,
            String message,
            String path,
            ZonedDateTime timestamp) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    /**
     * Instantiates a new Http error info.
     *
     * @param httpStatus the http status code and type.
     * @param path the request path.
     * @param message the error message.
     */
    public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
        this(httpStatus, message, path, ZonedDateTime.now());
    }

    public HttpStatus httpStatus() { return httpStatus; }
    public String message() { return message; }
    public String path() { return path; }
    public ZonedDateTime timestamp() { return timestamp; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HttpErrorInfo)) return false;
        HttpErrorInfo that = (HttpErrorInfo) o;
        return httpStatus == that.httpStatus
                && Objects.equals(message, that.message)
                && Objects.equals(path, that.path)
                && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus, message, path, timestamp);
    }

    @Override
    public String toString() {
        return "HttpErrorInfo{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + "'" +
                ", path='" + path + "'" +
                ", timestamp=" + timestamp +
                '}';
    }
}
