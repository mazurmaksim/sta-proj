package net.students.accounting.dao;

import net.students.accounting.entity.TaxDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository(value = "taxDictionaryRepository")
public interface TaxDictionaryRepository extends JpaRepository<TaxDictionary, Integer> {

    TaxDictionary getTaxDictionaryByDate(LocalDate date);
}
