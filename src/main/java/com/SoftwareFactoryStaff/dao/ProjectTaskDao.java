package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.ProjectTask;

import java.util.List;


public interface ProjectTaskDao {

    Long create(ProjectTask projectTask);

    ProjectTask read(Long id);

    void update(ProjectTask projectTask);

    void delete(ProjectTask projectTask);

    List<ProjectTask> findAll();

    List<ProjectTask> findAllProjectTasksByStaff(Long StaffId);

}
