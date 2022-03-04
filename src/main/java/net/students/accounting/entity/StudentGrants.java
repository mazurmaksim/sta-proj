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

    @Column(name = "get_date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false, referencedColumnName = "id")
    private Student student;

    @Column(name = "january")
    private Double january;

    @Column(name = "february")
    private Double february;

    @Column(name = "march")
    private Double march;

    @Column(name = "april")
    private Double april;

    @Column(name = "may")
    private Double may;

    @Column(name = "june")
    private Double june;

    @Column(name = "july")
    private Double july;

    @Column(name = "august")
    private Double august;

    @Column(name = "september")
    private Double september;

    @Column(name = "october")
    private Double october;

    @Column(name = "november")
    private Double november;

    @Column(name = "december")
    private Double december;

    @Column(name = "year")
    private Integer year;

    public Double getJanuary() {
        return january;
    }

    public void setJanuary(Double january) {
        this.january = january;
    }

    public Double getFebruary() {
        return february;
    }

    public void setFebruary(Double february) {
        this.february = february;
    }

    public Double getMarch() {
        return march;
    }

    public void setMarch(Double march) {
        this.march = march;
    }

    public Double getApril() {
        return april;
    }

    public void setApril(Double april) {
        this.april = april;
    }

    public Double getMay() {
        return may;
    }

    public void setMay(Double may) {
        this.may = may;
    }

    public Double getJune() {
        return june;
    }

    public void setJune(Double june) {
        this.june = june;
    }

    public Double getJuly() {
        return july;
    }

    public void setJuly(Double july) {
        this.july = july;
    }

    public Double getAugust() {
        return august;
    }

    public void setAugust(Double august) {
        this.august = august;
    }

    public Double getSeptember() {
        return september;
    }

    public void setSeptember(Double september) {
        this.september = september;
    }

    public Double getOctober() {
        return october;
    }

    public void setOctober(Double october) {
        this.october = october;
    }

    public Double getNovember() {
        return november;
    }

    public void setNovember(Double november) {
        this.november = november;
    }

    public Double getDecember() {
        return december;
    }

    public void setDecember(Double december) {
        this.december = december;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public void setGrant(Double grant) {
        GrantApply grantApply = new GrantApplyDecide();
        LocalDate today = LocalDate.now();

        if (grantApply.apply(today, 1)) {
                january = grant;
        }

        if (grantApply.apply(today, 2)) {
                february = grant;
        }

        if (grantApply.apply(today, 3)) {
                march = grant;
        }

        if (grantApply.apply(today, 4)) {
                april = grant;
        }

        if (grantApply.apply(today, 5)) {
                may = grant;
        }

        if (grantApply.apply(today, 6)) {
                june = grant;
        }

        if (grantApply.apply(today, 7)) {
                july = grant;
        }

        if (grantApply.apply(today, 8)) {
                august = grant;
        }

        if (grantApply.apply(today, 9)) {
                september = grant;
       }

        if (grantApply.apply(today, 10)) {
                october = grant;
        }

        if (grantApply.apply(today, 11)) {
                november = grant;
        }

        if (grantApply.apply(today, 12)) {
                december = grant;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
