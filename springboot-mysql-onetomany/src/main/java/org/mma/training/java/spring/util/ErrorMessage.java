package org.mma.training.java.spring.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = -5384814008813277936L;
	
	private Integer code;
	private String message;
	private String developerMessage;
	private String moreInfo;
	private String fieldName;
	private Severity severityLevel;
	private List<ErrorMessage> errorMessageList = new ArrayList<>();
	private List<String> formFieldNames = new ArrayList<>();
	
	public ErrorMessage() {}
	
	public ErrorMessage(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ErrorMessage(Integer code, String message, String fieldName) {
		super();
		this.code = code;
		this.message = message;
		this.fieldName = fieldName;
	}
	
	public ErrorMessage(String message, String fieldName) {
		super();
		this.message = message;
		this.fieldName = fieldName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Severity getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(Severity severityLevel) {
		this.severityLevel = severityLevel;
	}

	public List<ErrorMessage> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(List<ErrorMessage> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	public List<String> getFormFieldNames() {
		return formFieldNames;
	}

	public void setFormFieldNames(List<String> formFieldNames) {
		this.formFieldNames.clear();
		this.formFieldNames.addAll(formFieldNames);
	}
	
	public void addFormFieldName(String formFieldName) {
		this.formFieldNames.add(formFieldName);
	}	

}
