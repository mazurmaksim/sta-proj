package net.students.accounting.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Group;
import java.util.List;

@Entity
@Table(name = "student")
public class Students extends AbstractEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name="id",unique = true, nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "age")
    private Integer age;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "st_group"))
    private Grups stGroup;

    public Grups getStGroup() {
        return stGroup;
    }

    public void setStGroup(Grups stGroup) {
        this.stGroup = stGroup;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Students(){

    }

}
