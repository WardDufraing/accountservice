package kdg.superteam.userservice.dom;

import javassist.bytecode.ByteArray;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Student extends Account implements Serializable{

    @Column
    @ElementCollection
    private Map<Long,Integer> instruments;

    @Column
    @ElementCollection(targetClass=Long.class)
    private List<Long> musicParts;

    @Column
    @ElementCollection(targetClass=Long.class)
    private List<Long> exercises;

    @Column
    @Lob
    private ByteArray qrCode;

    public Student() {
        super();
        this.instruments = new HashMap<Long,Integer>();
        this.musicParts = new ArrayList<>();
        this.exercises = new ArrayList<>();
    }

    public Student(String lastName, String firstName, String email, String avatar, Address address, ByteArray qrCode) {
        super(lastName, firstName, email, avatar, address);
        this.instruments = new HashMap<Long,Integer>();
        this.musicParts = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.qrCode = qrCode;
    }

    public Student(String lastName, String firstName,  String email, Address address){
        super(lastName, firstName, email, address);
        this.instruments  = new HashMap<Long,Integer>();
        this.musicParts = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.qrCode = qrCode;
    }

    public Map<Long, Integer> getInstruments(){
        return instruments;
    }

    public void addInstrument(long key, int value){
        this.instruments.put(key,value);
    }

    public List<Long> getMusicParts(){
        return musicParts;
    }

    public void addMusicPart(long id){
        this.musicParts.add(id);
    }

    public List<Long> getExercises(){
        return exercises;
    }

    public void addExercise(long id){
        this.exercises.add(id);
    }

    public ByteArray getQrCode() {
        return qrCode;
    }

    public void setQrCode(ByteArray qrCode) {
        this.qrCode = qrCode;
    }
}
