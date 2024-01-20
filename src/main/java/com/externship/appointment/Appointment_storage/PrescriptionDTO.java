package com.externship.appointment.Appointment_storage;

import org.springframework.web.multipart.MultipartFile;

//Create a new DTO (Data Transfer Object) to handle the form data
public class PrescriptionDTO {
 private String appId;
 private String prescriptionText;
 private MultipartFile prescriptionImage; // Assuming you are using Spring's MultipartFile
public String getAppId() {
	return appId;
}
public void setAppId(String appId) {
	this.appId = appId;
}
public String getPrescriptionText() {
	return prescriptionText;
}
public void setPrescriptionText(String prescriptionText) {
	this.prescriptionText = prescriptionText;
}
public MultipartFile getPrescriptionImage() {
	return prescriptionImage;
}
public void setPrescriptionImage(MultipartFile prescriptionImage) {
	this.prescriptionImage = prescriptionImage;
}

 // Getters and Setters
}
