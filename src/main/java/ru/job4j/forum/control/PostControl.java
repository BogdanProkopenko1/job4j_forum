package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {

    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "edit";
    }

    @GetMapping("/post")
    public String post(@RequestParam("id") int id, Model model) {
        Post post = service.findPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            model.addAttribute("comments", post.getComments());
        }
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        int id = post.getId();
        if (id > 0) {
            service.findPostById(id).getComments().forEach(post::addComment);
            service.save(post);
            return "redirect:/post?id=" + id;
        }
        service.save(post);
        return "redirect:/index";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", service.findPostById(id));
        return "edit";
    }
}
