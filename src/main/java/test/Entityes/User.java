package test.Entityes;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
   private Integer id;
   private String username;
   private String password;
   private boolean active;

   @ElementCollection (targetClass = Role.class, fetch = FetchType.EAGER)
   @CollectionTable (name ="user_role", joinColumns = @JoinColumn(name = "user_id"))
   @Enumerated(EnumType.STRING)
   private Set<Role> roles;
   private Double money=0.0;

    @ManyToMany
    @JoinTable (name = "Basket",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name="basket_id"))
    List<Basket>baskets;

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}

