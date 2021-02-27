package net.students.accounting.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="finance_info")
public class Finance {

    @Id
    @GeneratedValue
    @Column(name="id",unique = true, nullable = false)
    private Long id;

    @Column(name="iin", length = 8)
    private String iin;

    @Column(name = "grant")
    private Double grant;

    public Finance(){}

    public void setId(Long id) {
        this.id = id;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public Double getGrant() {
        return grant;
    }

    public void setGrant(Double grant) {
        this.grant = grant;
    }

//    public Students getStudents() {
//        return students;
//    }
//
//    public void setStudents(Students students) {
//        this.students = students;
//    }
}
