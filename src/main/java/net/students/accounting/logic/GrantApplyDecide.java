package net.students.accounting.logic;

import java.time.LocalDate;

public class GrantApplyDecide implements GrantApply {

    @Override
    public boolean apply(LocalDate localDate, int monthsNumber) {
        return localDate.getMonth().getValue() == monthsNumber;
    }
}
