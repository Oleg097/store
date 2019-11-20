package test.Entityes;

import javax.persistence.*;
import java.util.Set;

@Entity

public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer dis_id;
    private Integer off;




    public Discount() {
    }

    public Discount(Integer dis_id, Integer off) {
        this.dis_id = dis_id;
        this.off = off;
    }

    public Integer getDis_id() {
        return dis_id;
    }

    public void setDis_id(Integer dis_id) {
        this.dis_id = dis_id;
    }

    public Integer getOff() {
        return off;
    }

    public void setOff(Integer off) {
        this.off = off;
    }
}
