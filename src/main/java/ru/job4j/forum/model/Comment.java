package ru.job4j.forum.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Comment {

    private String message;
    private final Calendar created = GregorianCalendar.getInstance();

    public static Comment of(String msg) {
        Comment comment = new Comment();
        comment.message = msg;
        return comment;
    }

    public String getMessage() {
        return message;
    }

    public Calendar getCreated() {
        return created;
    }
}
