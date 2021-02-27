package net.students.accounting.entity;

import javax.persistence.*;

@Entity
@Table(name="groups")
public class Grups {

    @Id
    @GeneratedValue
    @Column(name="id",unique = true, nullable = false)
    private Long id;

    @Column(name = "group_name", length = 10)
    private String groupName;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Grups(){}

}
