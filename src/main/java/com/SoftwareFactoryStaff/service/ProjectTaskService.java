package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    void addNewProjectTask(ProjectTask projectTask);

    void updateProjectTask(ProjectTask projectTask);

    void deleteProjectTask(ProjectTask projectTask);

    List<ProjectTask> getAllProjectTasks();

    List<ProjectTask> findAllProjectTasksByStaff(Long staffId);

    ProjectTask getProjectTaskById(Long id);

}
