package matt.springframework.springpetclinic.services;

import matt.springframework.springpetclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerServices extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
