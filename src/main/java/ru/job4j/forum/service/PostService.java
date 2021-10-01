package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.AuthorityRepository;
import ru.job4j.forum.store.PostRepository;
import ru.job4j.forum.store.UserRepository;

import java.util.*;

@Service
public class PostService {

    private final PostRepository storage;
    private final UserRepository users;
    private final AuthorityRepository authorities;

    public PostService(PostRepository storage, UserRepository users, AuthorityRepository authorities) {
        this.authorities = authorities;
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

    public void save(User user) {
        users.save(user);
    }

    public Authority findAuthority(String role_user) {
        return authorities.findByAuthority(role_user);
    }
}
