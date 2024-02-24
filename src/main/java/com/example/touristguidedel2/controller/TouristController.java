package com.example.touristguidedel2.controller;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/Tivoli")
public class TouristController {
    TouristService service;
    TouristAttraction attraction;

    public TouristController(){
        service = new TouristService();
    }

    @GetMapping(path="")
    public String showAttractions(Model model){
        model.addAttribute("attraction", service.getAll());
        return "Startpage";
    }

    @GetMapping("{ID}/Update")
    public String showUpdateAttraction(@PathVariable int ID, Model model) {
        TouristAttraction attraction = service.findByID(ID);
        model.addAttribute("attraction", attraction);
        return "Update";
    }

    @PostMapping("/Update")
    public String updateAttraction(TouristAttraction attraction) {
        service.updateAttraction(attraction);
        return "redirect:/Tivoli";
    }

    @GetMapping("/Add")
    public String newAttraction(Model model) {
        this.attraction = new TouristAttraction();
        model.addAttribute("attraction", attraction);
        return "Add";
    }

    @PostMapping("/Add")
    public String addNewAttraction(@ModelAttribute TouristAttraction attraction){
        service.addNewAttraction(attraction);
        return "redirect:/Tivoli";
    }

    @PostMapping("/{ID}/Delete")
    public String deleteAttraction(@PathVariable int ID){
        service.deleteAttraction(ID);
        return "redirect:/Tivoli";
    }
}
