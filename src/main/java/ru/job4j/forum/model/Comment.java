package ru.job4j.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
