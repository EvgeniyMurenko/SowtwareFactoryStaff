package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.MessageLink;

import java.util.List;

public interface MessageLinkService {

    void addNewMessageLink(MessageLink messageLink);

    void updateMessageLink(MessageLink messageLink);

    void deleteMessageLink(MessageLink messageLink);

    List<MessageLink> getAllMessageLinks();

    MessageLink getMessageLinkById(Long id);

}
