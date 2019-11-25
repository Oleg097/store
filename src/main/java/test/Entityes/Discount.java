package test.Entityes;

import javax.persistence.*;

@Entity

public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer dis_id;

    public Integer getDis_id() {
        return dis_id;
    }

    public void setDis_id(Integer dis_id) {
        this.dis_id = dis_id;
    }

    public Discount() {
    }


}
