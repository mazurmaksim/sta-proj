package net.students.accounting.entity;

import javax.persistence.*;

@Entity
@Table(name="finance_info")
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="inn")
    private String inn;

    public Finance(){}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String iin) {
        this.inn = iin;
    }
}
