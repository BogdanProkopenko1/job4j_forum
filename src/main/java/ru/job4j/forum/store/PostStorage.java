package ru.job4j.forum.store;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostStorage {

    private final Map<Integer, Post> posts = new HashMap<>();
    private AtomicInteger counterPost = new AtomicInteger(1);
    private List<User> users = new ArrayList<>();
    private AtomicInteger userId = new AtomicInteger(1);

    public PostStorage() {
        Post post = Post.of("Продаю машину ладу 01", "Новая", counterPost.get());
        post.addComment(Comment.of("Можно фото посмотреть"));
        posts.put(counterPost.getAndIncrement(), post);
    }

    public List<Post> getPosts() {
        return new ArrayList<>(posts.values());
    }

    public Post getPost(int id) {
        return posts.get(id);
    }

    public void save(Post post) {
        if (post != null) {
            if (post.getId() == 0) {
                post.setId(counterPost.get());
                posts.put(counterPost.getAndIncrement(), post);
                return;
            }
            posts.replace(post.getId(), post);
        }
    }

    public User save(User user) {
        users.add(user);
        user.setId(userId.getAndIncrement());
        return user;
    }
}
