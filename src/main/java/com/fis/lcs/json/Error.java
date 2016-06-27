package com.fis.lcs.json;

public enum Error {

	EMPTY_PAYLOAD("ERR01", "Invalid Payload. Payload can not be epmty"),
	DUPLICATE_PAYLOAD("ERR02", "Invalid Payload. Payload can not have duplicate strings"),
	INVALID_JSON_PAYLOAD("ERR03", "Invalid Payload format. Payload should be well formed Json");
	
	private String errorCode;
	private String errorMessage;
	private Error(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
