package com.bnt.Exception;

public class MailException extends Exception {

	private final String code;
	private final String description;
	private final String flowName;
	private final Throwable originalException;
	private final Object requestObject;

	public MailException(String code, String description, String flowName, Throwable originalException,
			Object requestObject) {
		super();
		this.code = code;
		this.description = description;
		this.flowName = flowName;
		this.originalException = originalException;
		this.requestObject = requestObject;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getFlowName() {
		return flowName;
	}

	public Throwable getOriginalException() {
		return originalException;
	}

	public Object getRequestObject() {
		return requestObject;
	}

	@Override
	public String toString() {
		return "MailException [code=" + code + ", description=" + description + ", flowName=" + flowName
				+ ", originalException=" + originalException + ", requestObject=" + requestObject + "]";
	}

	/*public static String prepareExceptionMessage(String code, String description, String flowName,
			Object requestObject) {
		StringBuilder message = new StringBuilder();
		message.append("\n ************************************************************");
		message.append("\n \t\t\t CommHubException STARTS");
		message.append("\n\n Flowname : " + flowName);
		message.append("\n Code : " + code);
		message.append("\n Description : " + description);
		if (!Util.isNULL(requestObject)) {
			message.append("\n Request Data : \n " + Util.convertObjectToJsonString(requestObject));
		}
		message.append("\n\n \t\t\t CommHubException ENDS");
		message.append("\n ************************************************************");
		return message.toString();
	}*/
}
