package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.MessageLink;

import java.util.List;

public interface MessageLinkDao {

    Long create(MessageLink messageLink);

    MessageLink read(Long id);

    void update(MessageLink messageLink);

    void delete(MessageLink messageLink);

    List<MessageLink> findAll();

}
