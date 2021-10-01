package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.PostRepository;
import ru.job4j.forum.store.UserRepository;

import java.util.*;

@Service
public class PostService {

    private final PostRepository storage;
    private final UserRepository users;

    public PostService(PostRepository storage, UserRepository users) {
        this.storage = storage;
        this.users = users;
    }

    public List<Post> getPosts() {
        return storage.getPosts();
    }

    public Post getPost(int id) {
        return storage.getPostById(id);
    }

    public void save(Post post) {
        storage.save(post);
    }

    public User save(User user) {
        return users.save(user);
    }
}
