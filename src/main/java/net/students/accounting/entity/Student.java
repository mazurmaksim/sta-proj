package net.students.accounting.entity;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Groups stGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finance_id", referencedColumnName = "id")
    private Finance finance;

    @Column(name = "user_pic")
    private String userPic;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    List<StudentGrants> grantsList;

    public List<StudentGrants> getGrantsList() {
        return grantsList;
    }

    public void setGrantsList(List<StudentGrants> grantsList) {
        this.grantsList = grantsList;
    }

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

    @Transient
    private boolean isValidPhoneNumber(String phone) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();

        for (String regionCode : phoneUtil.getSupportedRegions()) {
                    try {
                        phoneNumber = phoneUtil.parse(phone, regionCode);
                    } catch (NumberParseException e) {
                        System.err.println("NumberParseException was thrown: " + e);
                    }
                }
        return phoneUtil.isValidNumber(phoneNumber);
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

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (isValidPhoneNumber(phone)) {
            this.phone = phone;
        }
    }

    public Student() {

    }

}
