package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.Message;
import com.SoftwareFactoryStaff.model.User;

public interface MailService {

    void sendEmailAfterEstimateRespond(String recipientMail , Message message, User customerUser, String registrationLink);

}
