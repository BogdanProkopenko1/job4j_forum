package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final PostService service;

    public RegControl(PasswordEncoder encoder, PostService service) {
        this.encoder = encoder;
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, HttpServletRequest request) {
        if (service.findUserByUsername(user.getUsername()) == null) {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(service.findAuthorityByName("ROLE_USER"));
            user.setEmail(request.getParameter("email"));
            service.save(user);
            return "redirect:/index";
        }
        return "redirect:/login?exists=true";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
