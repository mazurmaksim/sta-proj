package net.students.accounting.exception;

import net.students.accounting.exception.group.GroupNotFoundException;
import net.students.accounting.exception.student.StudentNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerErrorHendler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        FieldErrorResponse fieldErrorResponse = new FieldErrorResponse();

        List<CustomFieldError> fieldErrors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            CustomFieldError fieldError = new CustomFieldError();
            fieldError.setField(((FieldError) error).getField());
            fieldError.setMessage(error.getDefaultMessage());
            fieldErrors.add(fieldError);
        });

        fieldErrorResponse.setFieldErrors(fieldErrors);
        return new ResponseEntity<>(fieldErrorResponse, status);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleStudentNotFoundException(StudentNotFoundException ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatus(HttpStatus.BAD_REQUEST.value());
        errorObject.setErrorCode(ErrorCode.BAD_REQUEST);
        errorObject.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleGroupNotFoundException(GroupNotFoundException ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatus(HttpStatus.BAD_REQUEST.value());
        errorObject.setErrorCode(ErrorCode.BAD_REQUEST);
        errorObject.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
