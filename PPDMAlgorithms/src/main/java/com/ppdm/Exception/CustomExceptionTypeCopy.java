package com.ppdm.Exception;

import com.ppdm.dto.PpdmDTO;

public class CustomExceptionTypeCopy extends PpdmDTO {
	
		private String errorMessage;
		 public CustomExceptionTypeCopy(final String errorMessage){
		 this.errorMessage = errorMessage;
		 }
		public String getErrorMessage() {
		 return errorMessage;
		 }
		

}
