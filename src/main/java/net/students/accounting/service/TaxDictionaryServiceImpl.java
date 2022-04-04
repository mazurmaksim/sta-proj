package net.students.accounting.service;

import net.students.accounting.dao.TaxDictionaryRepository;
import net.students.accounting.entity.TaxDictionary;

import javax.annotation.Resource;

public class TaxDictionaryServiceImpl implements TaxDictionaryService {

    TaxDictionaryRepository repository;

    @Override
    public void saveDictionaryEntry(TaxDictionary dictionary) {
        repository.save(dictionary);
    }

    @Resource(name = "taxDictionaryRepository")
    public void setRepository(TaxDictionaryRepository repository) {
        this.repository = repository;
    }
}
