package net.students.accounting.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

//    @Column(name = "status", nullable = false)
//    private String status;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

//    @Column(name = "age")
//    private Integer age;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups stGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finance_id", referencedColumnName = "id")
    private Finance finance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    public Groups getStGroup() {
        return stGroup;
    }

    public void setStGroup(Groups stGroup) {
        this.stGroup = stGroup;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

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

    public Student(){

    }

}
