package matt.springframework.springpetclinic.bootstrap;

import matt.springframework.springpetclinic.model.*;
import matt.springframework.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInitializer(OwnerServices ownerServices, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerServices = ownerServices;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count =petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }



    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded Pet Types... ");

        Owner owner1 = new Owner();
        owner1.setFirstName("Tony");
        owner1.setLastName("Stark");
        owner1.setAddress("10880 Malibu Point, 90265");
        owner1.setCity("Malibu");
        owner1.setTelephone("1231231234");

        Pet tonyPet = new Pet();
        tonyPet.setPetType(savedDogPetType);
        tonyPet.setOwner(owner1);
        tonyPet.setBirthDate(LocalDate.now());
        tonyPet.setName("Jarvis");
        owner1.getPets().add(tonyPet);

        ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Steve");
        owner2.setLastName("Rogers");
        owner2.setAddress("569 Leaman Place");
        owner2.setCity("Brooklyn");
        owner2.setTelephone("1231231234");

        Pet stevePet = new Pet();
        stevePet.setPetType(savedCatPetType);
        stevePet.setOwner(owner2);
        stevePet.setBirthDate(LocalDate.now());
        stevePet.setName("Carter");
        owner2.getPets().add(stevePet);

        ownerServices.save(owner2);

        System.out.println("Loaded Owners... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bruce");
        vet1.setLastName("Wayne");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Clark");
        vet2.setLastName("Kent");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
