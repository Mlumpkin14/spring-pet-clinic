package matt.springframework.springpetclinic.services.map;

import matt.springframework.springpetclinic.model.Visit;
import matt.springframework.springpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    private final VisitService visitService;

    public VisitMapService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Visit save(Visit object) {
        return null;
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}


