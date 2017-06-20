package com.SoftwareFactoryStaff.service;

import com.SoftwareFactoryStaff.dao.ProjectTaskDao;
import com.SoftwareFactoryStaff.model.ProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("projectTaskService")
public class ProjectTaskServiceImpl implements ProjectTaskService {

    private ProjectTaskDao projectTaskDao;


    @Autowired(required = true)
    public void setProjectTaskDao(ProjectTaskDao projectTaskDao) {
        this.projectTaskDao = projectTaskDao;
    }

    @Override
    public void addNewProjectTask(ProjectTask projectTask) {
        projectTaskDao.create(projectTask);
    }

    @Override
    public void updateProjectTask(ProjectTask projectTask) {
        projectTaskDao.update(projectTask);
    }

    @Override
    public void deleteProjectTask(ProjectTask projectTask) {
        projectTaskDao.delete(projectTask);
    }

    @Override
    public List<ProjectTask> getAllProjectTasks() {
        return projectTaskDao.findAll();
    }

    @Override
    public List<ProjectTask> findAllProjectTasksByStaff(Long staffId) {
        return projectTaskDao.findAllProjectTasksByStaff(staffId);
    }

    @Override
    public ProjectTask getProjectTaskById(Long id) {
        return projectTaskDao.read(id);
    }

}

