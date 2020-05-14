package matt.springframework.springpetclinic.repositories;

import matt.springframework.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);

}
