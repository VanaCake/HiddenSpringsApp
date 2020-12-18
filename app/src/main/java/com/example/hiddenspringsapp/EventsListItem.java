package com.example.hiddenspringsapp;

public class EventsListItem {
    private String eventDate;
    private String eventName;

    public EventsListItem(String eventDate, String eventName) {
        this.eventDate = eventDate;
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
