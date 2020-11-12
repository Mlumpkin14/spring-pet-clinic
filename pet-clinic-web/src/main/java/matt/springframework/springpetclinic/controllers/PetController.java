package matt.springframework.springpetclinic.controllers;

import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.model.PetType;
import matt.springframework.springpetclinic.services.OwnerServices;
import matt.springframework.springpetclinic.services.PetService;
import matt.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetTypeService petTypeService;
    private final OwnerServices ownerServices;
    private final PetService petService;

    public PetController(PetTypeService petTypeService, OwnerServices ownerServices, PetService petService) {
        this.petTypeService = petTypeService;
        this.ownerServices = ownerServices;
        this.petService = petService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerServices.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
