package matt.springframework.springpetclinic.services;

import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
