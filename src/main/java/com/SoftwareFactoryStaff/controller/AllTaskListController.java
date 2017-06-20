package com.SoftwareFactoryStaff.controller;

import com.SoftwareFactoryStaff.model.ProjectTask;
import com.SoftwareFactoryStaff.model.StaffInfo;
import com.SoftwareFactoryStaff.model.TaskMessage;
import com.SoftwareFactoryStaff.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/all-tasks")
@SessionAttributes("roles")
public class AllTaskListController {

    @Autowired
    ProjectTaskService projectTaskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllTask() {

        ModelAndView allTasksView = new ModelAndView("/allTaskList");

        List<ProjectTask> projectTaskList = projectTaskService.getAllProjectTasks();

        allTasksView.addObject("projectTaskList", projectTaskList);

        return allTasksView;

    }

    @RequestMapping(value = "/view/{projectTaskId}", method = RequestMethod.GET)
    public ModelAndView getProjectTaskView(@PathVariable Long projectTaskId, HttpSession httpSession) {

        ModelAndView projectTaskView = new ModelAndView("/allTaskView");

        ProjectTask projectTask = projectTaskService.getProjectTaskById(projectTaskId);

        StaffInfo currentStaffInfo = (StaffInfo) httpSession.getAttribute("staffInfo");

        List<TaskMessage> taskMessageList = new ArrayList<>(projectTask.getTaskMessages());

        TaskMessage taskMessage = taskMessageList.get(taskMessageList.size()-1);

        projectTaskView.addObject("projectTask", projectTask);
        projectTaskView.addObject("taskMessage", taskMessage);
        projectTaskView.addObject("isAccept", isStaffAccept(new ArrayList<>(projectTask.getStaffInfos()), currentStaffInfo));

        return projectTaskView;
    }

    @RequestMapping(value = "/accept/{projectTaskId}", method = RequestMethod.GET)
    public ModelAndView getAcceptProjectTask(@PathVariable Long projectTaskId,
                                             HttpSession httpSession) {

        ModelAndView projectTaskView = new ModelAndView("redirect:/all-task/view/"+projectTaskId+"/");


        StaffInfo currentStaffInfo = (StaffInfo) httpSession.getAttribute("staffInfo");

        ProjectTask projectTask = projectTaskService.getProjectTaskById(projectTaskId);

        List<StaffInfo> staffInfoList = new ArrayList<>(projectTask.getStaffInfos());

        if (!isStaffAccept(staffInfoList, currentStaffInfo)){
            projectTask.getStaffInfos().add(currentStaffInfo);
            projectTaskService.updateProjectTask(projectTask);
            System.out.println("=========================add!!!!!!!!!!!");
        }

        return projectTaskView;
    }

    private boolean isStaffAccept(List<StaffInfo> staffInfoList, StaffInfo currentStaffInfo){
        for (StaffInfo staffInfo : staffInfoList) {
            if (staffInfo.getId() == currentStaffInfo.getId()) {
                return true;
            }
        }
        return false;
    }

}
