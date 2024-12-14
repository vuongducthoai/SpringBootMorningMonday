package webapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "ProductType")
@Table(name = "ProductType")
public class ProductType {
    @Id
    @Column(name = "ProductTypeId")
    private short id;

    @Column(name = "ProductTypeName")
    private String name;

    @OneToMany(mappedBy = "productType")
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
