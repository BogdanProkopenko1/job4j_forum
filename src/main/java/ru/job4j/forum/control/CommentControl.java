package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.service.PostService;

@Controller
public class CommentControl {

    private final PostService service;

    public CommentControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/comment")
    public String save(@RequestParam("msg") String msg, @RequestParam("id") int id) {
        service.addPostComment(id, Comment.of(msg));
        return "redirect:/post?id=" + id;
    }
}
