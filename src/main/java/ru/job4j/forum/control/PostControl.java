package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "/edit";
    }

    @GetMapping("/post")
    public String post(@RequestParam("id") int id, Model model) {
        Post post = service.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", post.getComments());
        return "/post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        if (post.getId() > 0) {
            service.getPost(post.getId()).getComments().forEach(post::addComment);
        }
        service.save(post);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", service.getPost(id));
        return "/edit";
    }
}
