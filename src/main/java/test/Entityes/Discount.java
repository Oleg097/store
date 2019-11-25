package test.Entityes;

import javax.persistence.*;

@Entity

public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer dis_id;
    private Double value;
    private Integer productId;

    public Discount() {
    }

    public Discount(Double value, Integer productId) {
        this.value = value;
        this.productId = productId;
    }

    public Integer getDis_id() {
        return dis_id;
    }

    public void setDis_id(Integer dis_id) {
        this.dis_id = dis_id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
