package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.forum.model.Post;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    @Query("select distinct p from Post p left join fetch p.comments")
    List<Post> getPosts();

    @Query("select distinct p from Post p left join fetch p.comments where p.id = :id")
    Post getPostById(@Param("id") int id);
}
