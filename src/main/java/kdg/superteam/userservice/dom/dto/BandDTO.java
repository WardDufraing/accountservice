package kdg.superteam.userservice.dom.dto;

import java.util.Date;
import java.util.List;

public class BandDTO {
    private Long bandId;
    private String bandName;
    private List<StudentDTO> bandMembers;
    private List<Date> performanceDates;

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public List<StudentDTO> getBandMembers() {
        return bandMembers;
    }

    public void setBandMembers(List<StudentDTO> bandMembers) {
        this.bandMembers = bandMembers;
    }

    public List<Date> getPerformanceDates() {
        return performanceDates;
    }

    public void setPerformanceDates(List<Date> performanceDates) {
        this.performanceDates = performanceDates;
    }
}
