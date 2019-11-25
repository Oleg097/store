package test.Entityes;
import javax.persistence.*;
import java.util.List;

@Entity


public class Product  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer product_id;
    private String product_name;
    private String category;
    private String vendor;
    private String description;
    private Double price;
    private Double discount=0.0;
    @ManyToMany
    @JoinTable (name = "product_user",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name="username"))
    private List<User> users;

    public Product() {
    }

    public Product(String product_name, String category, String vendor, String description, Double price, Double discount, List<User> users) {
        this.product_name = product_name;
        this.category = category;
        this.vendor = vendor;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.users = users;
    }

    public Product(String product_name, String category, String vendor, String description, Double price, Double discount) {
        this.product_name = product_name;
        this.category = category;
        this.vendor = vendor;
        this.description = description;
        this.price = price;
        this.discount = discount;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}



