package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.TaskMessage;

import java.util.List;


public interface TaskMessageDao {

    Long create(TaskMessage taskMessage);

    TaskMessage read(Long id);

    void update(TaskMessage taskMessage);

    void delete(TaskMessage taskMessage);

    List<TaskMessage> findAll();

}
