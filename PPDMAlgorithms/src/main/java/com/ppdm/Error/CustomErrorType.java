package com.ppdm.Error;

import com.ppdm.dto.PpdmDTO;

public class CustomErrorType extends PpdmDTO {
private String errorMessage;
 public CustomErrorType(final String errorMessage){
 this.errorMessage = errorMessage;
 }

 public String getErrorMessage() {
 return errorMessage;
 }
}