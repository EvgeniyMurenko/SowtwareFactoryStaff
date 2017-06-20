package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.TaskMessageLink;

import java.util.List;

public interface TaskMessageLinkDao {

    Long create(TaskMessageLink taskMessageLink);

    TaskMessageLink read(Long id);

    void update(TaskMessageLink taskMessageLink);

    void delete(TaskMessageLink taskMessageLink);

    List<TaskMessageLink> findAll();

}
