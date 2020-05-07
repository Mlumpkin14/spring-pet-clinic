package matt.springframework.springpetclinic.bootstrap;

import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.model.PetType;
import matt.springframework.springpetclinic.model.Vet;
import matt.springframework.springpetclinic.services.OwnerServices;
import matt.springframework.springpetclinic.services.PetService;
import matt.springframework.springpetclinic.services.PetTypeService;
import matt.springframework.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerServices ownerServices, VetService vetService, PetTypeService petTypeService) {
        this.ownerServices = ownerServices;
        this.vetService = vetService;

        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types... ");

        Owner owner1 = new Owner();
        owner1.setFirstName("Tony");
        owner1.setLastName("Stark");

        ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Steve");
        owner2.setLastName("Rogers");

        ownerServices.save(owner2);

        System.out.println("Loaded Owners ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bruce");
        vet1.setLastName("Wayne");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Clark");
        vet2.setLastName("Kent");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
