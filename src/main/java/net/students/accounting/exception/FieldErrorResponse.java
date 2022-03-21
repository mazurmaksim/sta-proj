package net.students.accounting.exception;

import lombok.Data;

import java.util.List;

@Data
public class FieldErrorResponse {
    private List<CustomFieldError> fieldErrors;
}
