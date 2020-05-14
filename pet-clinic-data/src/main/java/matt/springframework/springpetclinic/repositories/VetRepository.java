package matt.springframework.springpetclinic.repositories;

import matt.springframework.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
