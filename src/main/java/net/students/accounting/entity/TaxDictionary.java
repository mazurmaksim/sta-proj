package net.students.accounting.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tax_dictionary")
public class TaxDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "army_tax")
    private Double armyTax;

    @Column(name = "income_tax")
    private Double incomeTax;

    @Column(name = "subsistence_level")
    private Double subsistenceLevel;

    @Column(name = "date")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getArmyTax() {
        return armyTax;
    }

    public void setArmyTax(Double armyTax) {
        this.armyTax = armyTax;
    }

    public Double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(Double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Double getSubsistenceLevel() {
        return subsistenceLevel;
    }

    public void setSubsistenceLevel(Double subsistenceLevel) {
        this.subsistenceLevel = subsistenceLevel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
