package webapp.model;

import jakarta.persistence.*;

@Entity(name="Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CartId")
    private int id;

    @Column(name="CartCode")
    private String code;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    private short quantity;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }
}
