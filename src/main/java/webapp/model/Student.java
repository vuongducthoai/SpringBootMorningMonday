package webapp.model;

import jakarta.persistence.*;

@Entity
public class Student {
    //You code here
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="StudentId")
    private int id;

    @Column(name="StudentCode")
    private String code;

    @ManyToOne
    @JoinColumn(name="classId")
    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    private String firstName;
    private String lastName;
    private boolean gender;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
