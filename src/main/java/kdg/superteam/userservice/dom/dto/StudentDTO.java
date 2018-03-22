package kdg.superteam.userservice.dom.dto;

import javassist.bytecode.ByteArray;
import kdg.superteam.userservice.dom.Account;

import java.util.List;
import java.util.Map;

public class StudentDTO extends AccountDTO {
    private Map<Long, Integer> instruments;
    private List<Long> musicParts;
    private List<Long> exercises;
    private ByteArray qrCode;

    public Map<Long, Integer> getInstruments() {
        return instruments;
    }

    public void setInstruments(Map<Long, Integer> instruments) {
        this.instruments = instruments;
    }

    public List<Long> getMusicParts() {
        return musicParts;
    }

    public void setMusicParts(List<Long> musicParts) {
        this.musicParts = musicParts;
    }

    public List<Long> getExercises() {
        return exercises;
    }

    public void setExercises(List<Long> exercises) {
        this.exercises = exercises;
    }

    public ByteArray getQrCode() {
        return qrCode;
    }

    public void setQrCode(ByteArray qrCode) {
        this.qrCode = qrCode;
    }
}
