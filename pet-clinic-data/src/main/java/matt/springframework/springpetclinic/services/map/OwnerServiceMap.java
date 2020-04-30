package matt.springframework.springpetclinic.services.map;

import com.sun.xml.bind.v2.model.core.ID;
import matt.springframework.springpetclinic.model.Owner;
import matt.springframework.springpetclinic.services.CrudService;
import matt.springframework.springpetclinic.services.OwnerServices;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerServices {
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
        return super.save(object.getId(), object);
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
