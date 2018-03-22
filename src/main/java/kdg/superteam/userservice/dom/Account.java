package kdg.superteam.userservice.dom;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
public abstract class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate birthDate;

    @Column
    @NotNull
    private String email;

    @Column
    @DefaultValue("bla")
    private String avatar;

    @Column
    private boolean isAdmin;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Address address;

    @Column
    private boolean isSignedIn;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> topics;

    public Account() {
        this.topics = new ArrayList<>();
    }

    public Account(String email){
        this.email = email;
        this.topics = new ArrayList<>();
    }

    public Account(String firstName, String lastName, String email, Address address){
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.topics = new ArrayList<>();
        this.address = address;
    }

    public Account(String lastName, String firstName, String email, String avatar, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.topics = new ArrayList<>();
    }

    public void convertAndSetBirthdate(String birthdate){
        this.birthDate = LocalDate.parse(birthdate);
    }
    public long getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isSignedIn() {
        return isSignedIn;
    }

    public void setSignedIn(boolean signedIn) {
        isSignedIn = signedIn;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void addTopic(String topic) {
        this.topics.add(topic);
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}
