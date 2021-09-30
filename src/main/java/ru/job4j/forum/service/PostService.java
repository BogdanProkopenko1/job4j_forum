package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.storage.PostStorage;

import java.util.*;

@Service
public class PostService {

    private final PostStorage storage;

    public PostService(PostStorage storage) {
        this.storage = storage;
    }

    public List<Post> getPosts() {
        return storage.getPosts();
    }

    public Post getPost(int id) {
        return storage.getPost(id);
    }

    public void save(Post post) {
        storage.save(post);
    }

    public User save(User user) {
        return storage.save(user);
    }
}
