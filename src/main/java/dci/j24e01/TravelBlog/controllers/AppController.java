package dci.j24e01.TravelBlog.controllers;

import dci.j24e01.TravelBlog.repositories.VacationPointRepository;
import dci.j24e01.TravelBlog.service.AdminService;
import dci.j24e01.TravelBlog.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AppController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private VacationService vacationService;
    @Autowired
    private VacationPointRepository vacationPointRepository;

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        model.addAttribute("vacationPoints", vacationService.getAllVacationPoints());
        model.addAttribute("approvedVacationPoints", vacationPointRepository.findAllByApprovedTrue());
        boolean isLoggedIn = authentication != null && authentication.isAuthenticated();
        model.addAttribute("loggedIn", isLoggedIn);
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/delete")
    public String deleteVacationPoint(@RequestParam Long id) {
        adminService.deleteVacationPoint(id);
        return "redirect:/admin_panel";
    }

    @PostMapping("/approve")
    public String approveVacationPoint(@RequestParam Long id) {
        vacationService.updateApprovalStatus(id, true);
        return "redirect:/admin_panel";
    }

    @PostMapping("/submit")
    public String submitVacationPoint(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(required = false) MultipartFile[] photos,
            @RequestParam(required = false) String route

    ) {

        vacationService.saveVacationPoint(title, description, latitude, longitude, photos, route);


        return "redirect:/";
    }

    @GetMapping("/admin_panel")
    public String adminPanel(Model model, Authentication authentication) {
        boolean isLoggedIn = authentication != null && authentication.isAuthenticated();
        model.addAttribute("vacationPoints", adminService.getAllVacationPoints());
        model.addAttribute("loggedIn", isLoggedIn);
        return "admin_panel";
    }
}