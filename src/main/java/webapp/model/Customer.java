package webapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity(name="Customer")
public class Customer {
    @Id
    @Column(name="CustomerId")
    private String id;

    private String firstName;
    private String lastName;
    private String company;
    private String city;
    private String country;
    private String phone1;
    private String phone2;
    private String email;
    private Date subscriptionDate;
    private String website;

    public Customer(String id, String firstName, String lastName, String company, String city, String country, String phone1, String phone2, String email, Date subscriptionDate, String website) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.city = city;
        this.country = country;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.subscriptionDate = subscriptionDate;
        this.website = website;
    }

    public Customer() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
