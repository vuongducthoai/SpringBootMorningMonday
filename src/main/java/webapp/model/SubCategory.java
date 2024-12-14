package webapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "SubCategory")
@Table(name="SubCategory")
public class SubCategory {
    @Id
    @Column(name = "SubCategoryId")
    private short id;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    @Column(name = "SubCategoryName")
    private String name;

    @OneToMany(mappedBy = "subCategory")
    private List<Product> products;

    // Getters and Setters
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
