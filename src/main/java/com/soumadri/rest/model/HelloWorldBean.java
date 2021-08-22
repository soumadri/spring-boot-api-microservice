package com.soumadri.rest.model;

public class HelloWorldBean {
    String message;

    public HelloWorldBean(String helloWorld) {
        this.message = helloWorld;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
