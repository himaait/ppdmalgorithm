package com.ppdm.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldValidationExceptionDetailsCopy {
	
	private String exception_title;
	 private int exception_status;
	 private String exception_detail;
	 private long exception_timeStamp;
	 private String exception_path;
	 private String exception_developer_Message;
	 private Map<String, List<FieldValidationExceptionCopy>> exceptions =
	 new HashMap<String, List<FieldValidationExceptionCopy>>();
	public String getException_title() {
		return exception_title;
	}
	public void setException_title(String exception_title) {
		this.exception_title = exception_title;
	}
	public int getException_status() {
		return exception_status;
	}
	public void setException_status(int exception_status) {
		this.exception_status = exception_status;
	}
	public String getException_detail() {
		return exception_detail;
	}
	public void setException_detail(String exception_detail) {
		this.exception_detail = exception_detail;
	}
	public long getException_timeStamp() {
		return exception_timeStamp;
	}
	public void setException_timeStamp(long exception_timeStamp) {
		this.exception_timeStamp = exception_timeStamp;
	}
	public String getException_path() {
		return exception_path;
	}
	public void setException_path(String exception_path) {
		this.exception_path = exception_path;
	}
	public String getException_developer_Message() {
		return exception_developer_Message;
	}
	public void setException_developer_Message(String exception_developer_Message) {
		this.exception_developer_Message = exception_developer_Message;
	}
	public Map<String, List<FieldValidationExceptionCopy>> getExceptions() {
		return exceptions;
	}
	public void setExceptions(Map<String, List<FieldValidationExceptionCopy>> exceptions) {
		this.exceptions = exceptions;
	}
	 
	 

}
