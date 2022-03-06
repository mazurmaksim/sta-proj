package net.students.accounting.entity;

import net.students.accounting.logic.GrantApply;
import net.students.accounting.logic.GrantApplyDecide;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student_grants")
public class StudentGrants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(name = "months")
    private LocalDate months;

    @Column(name = "grants")
    private Double grants;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getMonths() {
        return months;
    }

    public void setMonths(LocalDate months) {
        this.months = months;
    }

    public Double getGrants() {
        return grants;
    }

    public void setGrants(Double grants) {
        this.grants = grants;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
