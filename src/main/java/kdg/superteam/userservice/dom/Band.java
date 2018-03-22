package kdg.superteam.userservice.dom;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Band implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long groupId;

    @Column
    private String bandName;

    @Column
    @OneToMany(targetEntity = Student.class,fetch = FetchType.EAGER)
    private List<Student> bandMembers;

    @Column
    @ElementCollection(targetClass=Date.class)
    private List<Date> performanceDates;

    public Band(){

    }

    public Band(String bandName){
        this.bandName = bandName;
        this.bandMembers = new ArrayList<>();
        this.performanceDates = new ArrayList<>();
    }

    public Band(String bandName, List<Student> bandMembers){
        this.bandName = bandName;
       this.bandMembers = new ArrayList<>();
        this.bandMembers = bandMembers;
        this.performanceDates = new ArrayList<>();
    }

    public String getBandName(){
        return bandName;
    }

    public void setBandName(String bandName){
        this.bandName = bandName;
    }

    public void addBandMember(Student student){
        this.bandMembers.add(student);
    }

    public List<Student> getBandMembers(){
        return bandMembers;
    }

    public void addPerformaceDate(Date performanceDate){
        this.performanceDates.add(performanceDate);
    }

    public List<Date> getPerformanceDates(){
        return performanceDates;
    }

    public long getGroupId(){
        return groupId;
    }
}
