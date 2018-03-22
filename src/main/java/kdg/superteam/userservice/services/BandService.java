package kdg.superteam.userservice.services;

import kdg.superteam.userservice.dom.Band;
import kdg.superteam.userservice.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    public List<Band> getBands(){
        return bandRepository.findAll();
    }

    public void addBand(Band band){
        bandRepository.save(band);
    }

    public Band getBandByBandName(String bandName){
        return bandRepository.findBandByBandName(bandName);
    }

    public Band getById(long id){
        return bandRepository.findOne(id);
    }

    public void removeBand(long id){
        bandRepository.delete(id);
    }

    public void removeBands(){
        bandRepository.deleteAll();
    }
}
