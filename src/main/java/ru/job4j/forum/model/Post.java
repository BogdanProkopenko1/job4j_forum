package ru.job4j.forum.model;

import java.util.*;

public class Post {

    private int id;
    private String name;
    private String desc;
    private final Calendar created = GregorianCalendar.getInstance();
    private List<Comment> comments = new ArrayList<>();

    public static Post of(String name, String desc, int id) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        post.desc = desc;
        return post;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Calendar getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
