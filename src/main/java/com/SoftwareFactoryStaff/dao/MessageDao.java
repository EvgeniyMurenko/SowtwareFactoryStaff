package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.Message;

import java.util.List;


public interface MessageDao {

    Long create(Message message);

    Message read(Long id);

    void update(Message message);

    void delete(Message message);

    List<Message> findAll();

}
