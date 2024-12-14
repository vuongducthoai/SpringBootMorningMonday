package webapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Category")
@Table(name="Category")
public class Category {
    @Id
    @Column(name = "CategoryId")
    private short id;

    @Column(name = "CategoryName")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategories;

    // Getters and Setters
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
