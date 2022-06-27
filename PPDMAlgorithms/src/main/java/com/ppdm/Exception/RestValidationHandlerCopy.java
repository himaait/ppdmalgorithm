package com.ppdm.Exception;

import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestValidationHandlerCopy {
 private MessageSource messageSource;
 @Autowired
 public RestValidationHandlerCopy(MessageSource messageSource) {
 this.messageSource = messageSource;
 }
 // method to handle validation error
 @ExceptionHandler(MethodArgumentNotValidException.class)
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 public ResponseEntity<FieldValidationExceptionDetailsCopy> handleValidationError(
 MethodArgumentNotValidException mNotValidException,
HttpServletRequest request) {

FieldValidationExceptionDetailsCopy fErrorDetails =
 new FieldValidationExceptionDetailsCopy();
 fErrorDetails.setException_timeStamp(new Date().getTime());
 fErrorDetails.setException_status(HttpStatus.BAD_REQUEST.value());
 fErrorDetails.setException_title("Field Validation Error");
 fErrorDetails.setException_detail("Input Field Validation Failed");
 fErrorDetails.setException_developer_Message(
 mNotValidException.getClass().getName());
 fErrorDetails.setException_path(request.getRequestURI());
 BindingResult result = mNotValidException.getBindingResult();
 List<FieldError> fieldErrors = result.getFieldErrors();
 for (FieldError error : fieldErrors) {
 FieldValidationExceptionCopy fError = processFieldError(error);
List<FieldValidationExceptionCopy> fValidationErrorsList =
 fErrorDetails.getExceptions().get(error.getField());
 if (fValidationErrorsList == null) {
 fValidationErrorsList =
 new ArrayList<FieldValidationExceptionCopy>();
 }
fValidationErrorsList.add(fError);
fErrorDetails.getExceptions().put(
 error.getField(), fValidationErrorsList);
 }
 return new ResponseEntity<FieldValidationExceptionDetailsCopy>(
 fErrorDetails, HttpStatus.BAD_REQUEST);
 }
 // method to process field error
 private FieldValidationExceptionCopy processFieldError(final FieldError error) {
 FieldValidationExceptionCopy fieldValidationError =
 new FieldValidationExceptionCopy();
 if (error != null) {
 Locale currentLocale = LocaleContextHolder.getLocale();
 String msg = messageSource.getMessage(
 error.getDefaultMessage(), null, currentLocale);
 fieldValidationError.setField(error.getField());
fieldValidationError.setType(MessageType.ERROR);
fieldValidationError.setMessage(msg);
 }
 return fieldValidationError;
 }
}
