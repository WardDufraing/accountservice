package kdg.superteam.userservice.repository;

import kdg.superteam.userservice.dom.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends CrudRepository<Band,Long>{
    Band findBandByBandName(String bandName);
    List<Band> findAll();
}
