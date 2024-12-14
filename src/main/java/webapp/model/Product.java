package webapp.model;

import jakarta.persistence.*;
import java.util.*;

@Entity(name = "Product")
@Table(name="Product")
public class Product {
    @Id
    @Column(name = "ProductId")
    private long id;

    @ManyToOne
    @JoinColumn(name = "SubCategoryId")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "ProductTypeId")
    private ProductType productType;

    @Column(name = "ProductTitle")
    private String title;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Colour")
    private String colour;

    @Column(name = "Usage")
    private String usage;

    @Column(name = "Price")
    private int price;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
