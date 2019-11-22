package test.Entityes;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity

public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer basket_id;
    private String username;
    private Integer product_id;

    @ManyToMany
    @JoinTable(name = "Basket",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @ManyToMany
    @JoinTable(name = "Basket",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "username"))
    private List<User> users;

    public Basket() {
    }

    public Basket(String username, Integer product_id) {
        this.username = username;
        this.product_id = product_id;
    }

    public Integer getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(Integer basket_id) {
        this.basket_id = basket_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}

