package dci.j24e01.TravelBlog.controllers;

import dci.j24e01.TravelBlog.models.Creator;
import dci.j24e01.TravelBlog.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutController {

    private final CreatorRepository creatorRepository;

    @Autowired
    public AboutController(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    @GetMapping("/about")
    public String about(Model model) {
        List<Creator> creators = creatorRepository.findAll();
        model.addAttribute("creators", creators);
        return "about";
    }
}
