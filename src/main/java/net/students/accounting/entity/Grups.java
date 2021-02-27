package net.students.accounting.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="grups")
public class Grups {

    @Id
    @GeneratedValue
    @Column(name="id",unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group")
    private Students students;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Grups(){}

}
