package net.students.accounting.entity;

import javax.persistence.*;

@Entity
@Table(name="finance_info")
public class Finance  extends AbstractEntity<Long> {

    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name="iin")
    private String iin;

    @Column(name = "grant")
    private Double grant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Students students;

    public Finance(){}

    @Override
    public Long getId() {
        return null;
    }

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

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
