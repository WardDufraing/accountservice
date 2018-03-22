package kdg.superteam.userservice.controller;

import kdg.superteam.userservice.dom.Band;
import kdg.superteam.userservice.dom.dto.BandDTO;
import kdg.superteam.userservice.services.BandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class BandRestController {

    @Autowired
    public BandService bandService;

    @Autowired
    private ModelMapper modelMapper;


    Band justgoogleit = new Band("JustGoogleIt");

    public BandRestController(){

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(BandDTO bandDTO){
        Band band = convertToEntity(bandDTO);
        bandService.addBand(band);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BandDTO getById(@PathVariable long id) {

        return convertToDto(bandService.getById(id));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BandDTO> getAll() {
        bandService.removeBands();
        bandService.addBand(justgoogleit);
        List<Band> bands = bandService.getBands();
        return bands.stream()
                .map(band -> convertToDto(band))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/groupname/{groupname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BandDTO getByUserName(@PathVariable String bandname) {
        bandService.removeBands();
        bandService.addBand(justgoogleit);
        return convertToDto(bandService.getBandByBandName(bandname));
    }

    private BandDTO convertToDto(Band band) {
        BandDTO bandDTO = modelMapper.map(band, BandDTO.class);
        return  bandDTO;
    }

    private Band convertToEntity(BandDTO bandDTO) {
        Band band = modelMapper.map(bandDTO, Band.class);
        return band;
    }
}
