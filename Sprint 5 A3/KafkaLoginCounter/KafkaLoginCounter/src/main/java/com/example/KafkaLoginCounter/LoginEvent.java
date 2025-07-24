package com.example.KafkaLoginCounter;


public class LoginEvent {
    private String userId;

    public LoginEvent() {}
    public LoginEvent(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
