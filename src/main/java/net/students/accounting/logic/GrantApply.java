package net.students.accounting.logic;

import java.time.LocalDate;

public interface GrantApply {
    boolean apply(LocalDate localDate, int monthsNumber);
}
