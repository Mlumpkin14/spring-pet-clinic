package matt.springframework.springpetclinic.controllers;

import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.services.OwnerServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerServices ownerServices;

    public OwnerController(OwnerServices ownerServices) {
        this.ownerServices = ownerServices;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


//    @RequestMapping({"","/", "/index", "/index.html"})
//    public String listOwners(Model model){
//
//        model.addAttribute("owners",ownerServices.findAll());
//
//        return "owners/index";
//    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping()
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = this.ownerServices.findAllByLastNameLike("%"+ owner.getLastName() + "%");

        if(results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }  else if (results.size()== 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerServices.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            Owner savedOwner = ownerServices.save(owner);
            return "redirect:/owners/" + owner.getId();
        }
    }


    @GetMapping("/owners/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute(ownerServices.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,
                                         @PathVariable("ownerId") Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            owner.setId(ownerId);
            Owner savedOwenr = ownerServices.save(owner);
            return "redirect:/owners/{ownerId}";
        }
    }
}
