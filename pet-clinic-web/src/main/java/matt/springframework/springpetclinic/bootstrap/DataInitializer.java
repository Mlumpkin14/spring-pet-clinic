package matt.springframework.springpetclinic.bootstrap;

import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.model.Vet;
import matt.springframework.springpetclinic.services.OwnerServices;
import matt.springframework.springpetclinic.services.VetService;
import matt.springframework.springpetclinic.services.map.OwnerServiceMap;
import matt.springframework.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerServices ownerServices;
    private final VetService vetService;

    public DataInitializer() {
        ownerServices = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Tony");
        owner1.setLastName("Stark");

        ownerServices.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Steve");
        owner2.setLastName("Rogers");

        ownerServices.save(owner2);

        System.out.println("Loaded Owners ");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Bruce");
        vet1.setLastName("Wayne");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Clark");
        vet2.setLastName("Kent");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
