package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegControl {

    private final PostService service;

    public RegControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/index";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
