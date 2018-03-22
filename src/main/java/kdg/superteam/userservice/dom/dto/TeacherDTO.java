package kdg.superteam.userservice.dom.dto;

import java.util.List;

public class TeacherDTO extends AccountDTO {
    private List<Long> lessons;
    private List<Long> instruments;
    private List<StudentDTO> students;
    private List<BandDTO> bands;

    public List<Long> getLessons() {
        return lessons;
    }

    public void setLessons(List<Long> lessons) {
        this.lessons = lessons;
    }

    public List<Long> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Long> instruments) {
        this.instruments = instruments;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public List<BandDTO> getBands() {
        return bands;
    }

    public void setBands(List<BandDTO> bands) {
        this.bands = bands;
    }
}
