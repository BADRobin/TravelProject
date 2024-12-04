package dci.j24e01.TravelBlog.controllers;

import dci.j24e01.TravelBlog.models.HeroSettings;
import dci.j24e01.TravelBlog.models.Location;
import dci.j24e01.TravelBlog.models.PendingLocation;
import dci.j24e01.TravelBlog.repositories.HeroSettingsRepository;
import dci.j24e01.TravelBlog.repositories.LocationRepository;
import dci.j24e01.TravelBlog.repositories.PendingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin_panel")
public class AdminController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PendingLocationRepository pendingLocationRepository;

    @Autowired
    private HeroSettingsRepository heroSettingsRepository;

    // Display Admin Panel
    @GetMapping
    public String adminPanel(Model model) {

        HeroSettings heroSettings = heroSettingsRepository.findTopByOrderByIdDesc();

//        List<Location> locations = locationRepository.findAll();  //TODO: front end has to be rearranged, otherwise you get an error
        List<PendingLocation> pendingLocations = pendingLocationRepository.findAll();

        model.addAttribute("heroSettings", heroSettings);
//        model.addAttribute("locations", locations);  //TODO: front end has to be rearranged, otherwise you get an error
        model.addAttribute("pendingLocations", pendingLocations);
        return "admin_panel";
    }

    @GetMapping("/hero_settings")
    public String getHeroSettings(Model model) {
        HeroSettings heroSettings = heroSettingsRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("heroSettings", heroSettings);
        return "admin_panel";
    }


    @PostMapping("/hero_settings")
    public String saveHeroSettings(@RequestParam("background_image_url") String backgroundImageUrl,
                                   @RequestParam("title") String title, Model model) {

        HeroSettings heroSettings = heroSettingsRepository.findAll().stream().findFirst().orElse(new HeroSettings());


        heroSettings.setBackgroundImageUrl(backgroundImageUrl);
        heroSettings.setTitle(title);


        heroSettingsRepository.save(heroSettings);


        model.addAttribute("heroSettings", heroSettings);


        return "admin_panel";
    }

    // Handle the form submission to update the status
    @PostMapping("/save_status/{id}")
    public String saveStatus(@RequestParam("status") PendingLocation.Status status,
                             @PathVariable("id") Integer id,
                             Model model) {
        // Fetch the PendingLocation by ID
        PendingLocation pendingLocation = pendingLocationRepository.findById(id).orElse(null);

        if (pendingLocation != null) {
            // Update the status
            pendingLocation.setStatus(status);
            pendingLocationRepository.save(pendingLocation); // Save the updated status to the DB
        }

        // Redirect back to the admin panel
        return "redirect:/admin_panel";
    }

}






