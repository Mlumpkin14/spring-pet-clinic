package matt.springframework.springpetclinic.services.map;

import com.sun.xml.bind.v2.model.core.ID;
import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.model.Pet;
import matt.springframework.springpetclinic.services.CrudService;
import matt.springframework.springpetclinic.services.OwnerServices;
import matt.springframework.springpetclinic.services.PetService;
import matt.springframework.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerServices {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null) {
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType()!=null){
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw new RuntimeException("Pet type is Required");
                    }
                    if(pet.getId()==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
