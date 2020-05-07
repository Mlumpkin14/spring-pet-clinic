package matt.springframework.springpetclinic.services.map;

import matt.springframework.springpetclinic.model.Speciality;
import matt.springframework.springpetclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialtyServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtiesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }


    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }
}
