package com.soumadri.rest.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamep;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamep, String message, String details) {
        this.timestamep = timestamep;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamep() {
        return timestamep;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
