package com.groupware.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.multipart.MultipartFile;

public class EmailVO {
	String emailTitle;
	String emailAddress;
	String emailContent;
	String emailPassword;
	String emailRecieversNames;
	List<String> emailRecievers;
	MultipartFile emailFile = null;
	String emailFileName;
	
	public String getEmailTitle() {
		return emailTitle;
	}
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public List<String> getEmailRecievers() {
		return emailRecievers;
	}
	public void setEmailRecievers(List<String> emailRecievers) {
		this.emailRecievers = emailRecievers;
	}
	public MultipartFile getEmailFile() {
		return emailFile;
	}
	public void setEmailFile(MultipartFile emailFile) {
		this.emailFile = emailFile;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	public String getEmailRecieversNames() {
		return emailRecieversNames;
	}
	public void setEmailRecieversNames(String emailRecieversNames) {
		this.emailRecieversNames = emailRecieversNames;
	}
	public String getEmailFileName() {
		return emailFileName;
	}
	public void setEmailFileName(String emailFileName) {
		this.emailFileName = emailFileName;
	}
	
	
}
