package net.students.accounting.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="grups")
public class Grups extends AbstractEntity<Long> implements Serializable {

    @Id
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
    private String group;

    public Long getId() {
        return id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Students> students;

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Grups(){}

}
