package net.students.accounting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tax_dictionary")
public class TaxDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     *
     * This variable is in percent
     *
     * **/
    @Column(name = "army_tax")
    private Double armyTax;

    /**
     *
     * This variable is in percent
     *
     * **/
    @Column(name = "income_tax")
    private Double incomeTax;

    /**
     *
     * This variable is in currency
     * for example 2000 HRN
     *
     * **/
    @Column(name = "subsistence_level")
    private Double subsistenceLevel;

    @Column(name = "date")
    private LocalDate date;
}
