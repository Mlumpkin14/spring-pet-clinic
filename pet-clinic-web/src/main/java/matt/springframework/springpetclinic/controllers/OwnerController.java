package matt.springframework.springpetclinic.controllers;

import matt.springframework.springpetclinic.services.OwnerServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/Owners")
@Controller
public class OwnerController {

    private final OwnerServices ownerServices;

    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }

    @RequestMapping({"","/", "/index", "/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners",ownerServices.findAll());

        return "Owners/index";
    }
}
