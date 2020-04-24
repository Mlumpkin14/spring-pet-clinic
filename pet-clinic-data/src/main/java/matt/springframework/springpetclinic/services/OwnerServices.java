package matt.springframework.springpetclinic.services;

import matt.springframework.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerServices {

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
