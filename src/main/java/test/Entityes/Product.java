package test.Entityes;
import javax.persistence.*;
import java.util.Set;

@Entity


public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer product_id;
    private String product_name;
    private String category;
    private String vendor;
    private String description;
    private Double price;
    private Integer discount;
    private Integer qty;

    public Product() {
    }

    public Product(String product_name, String category, String vendor, String description, Double price, Integer discount, Integer qty) {
        this.product_name = product_name;
        this.category = category;
        this.vendor = vendor;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.qty = qty;

    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategoty() {
        return category;
    }

    public void setCategoty(String categoty) {
        this.category = categoty;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
