package com.bnt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MailDetails {

	@JsonProperty("to_email_id")
	private String toEmailId;
	
	@JsonProperty("email_subject")
	private String emailSubject;
	
	@JsonProperty("email_msg_content")
	private String emailMsgContent;

	public MailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MailDetails(String toEmailId, String emailSubject, String emailMsgContent) {
		super();
		this.toEmailId = toEmailId;
		this.emailSubject = emailSubject;
		this.emailMsgContent = emailMsgContent;
	}

	public String getToEmailId() {
		return toEmailId;
	}

	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailMsgContent() {
		return emailMsgContent;
	}

	public void setEmailMsgContent(String emailMsgContent) {
		this.emailMsgContent = emailMsgContent;
	}

	@Override
	public String toString() {
		return "MailDetails [toEmailId=" + toEmailId + ", emailSubject=" + emailSubject + ", emailMsgContent="
				+ emailMsgContent + "]";
	}
	
	
	
	
	
}
