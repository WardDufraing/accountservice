package kdg.superteam.userservice.dom;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends Account implements Serializable {

    @Column
    @ElementCollection(targetClass=Long.class)
    private List<Long> lessons;

    @Column
    @ElementCollection(targetClass=Long.class)
    private List<Long> instruments;

    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private List<Student> students;

    @OneToMany(targetEntity = Band.class)
    private List<Band> bands;

    public Teacher(){
        super();
        this.lessons = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.bands = new ArrayList<>();
    }

    public Teacher(String lastName, String firstName, String email, String avatar, Address address) {
        super(lastName, firstName, email, avatar, address);
        this.lessons = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.bands = new ArrayList<>();
    }

    public Teacher(String lastName, String firstName, String email, Address address){
        super(lastName, firstName, email, address);
        this.lessons = new ArrayList<>();
        this.instruments = new ArrayList<>();
        this.students = new ArrayList<>();
        this.bands = new ArrayList<>();
    }

    public List<Long> getLessons() {
        return lessons;
    }

    public List<Long> getInstruments() {
        return instruments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Band> getBands() {
        return bands;
    }

    public void addLesson(long id){
        this.lessons.add(id);
    }

    public void addInstrument(long id){
        this.instruments.add(id);
    }

    public void addStudentToTeacher(Student student){
        this.students.add(student);
    }

    public void addGroupToTeacher(Band band){
        this.bands.add(band);
    }
    /**/
}
