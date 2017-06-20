package com.SoftwareFactoryStaff.controller;

import com.SoftwareFactoryStaff.comparator.TaskMessageByDateComparator;
import com.SoftwareFactoryStaff.model.ProjectTask;
import com.SoftwareFactoryStaff.model.StaffInfo;
import com.SoftwareFactoryStaff.model.TaskMessage;
import com.SoftwareFactoryStaff.service.ProjectTaskService;
import com.SoftwareFactoryStaff.service.TaskMessageService;
import com.SoftwareFactoryStaff.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/my-tasks")
@SessionAttributes("roles")
public class MyTaskListController {

    @Autowired
    ProjectTaskService projectTaskService;

    @Autowired
    TaskMessageService taskMessageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllMyTasks(HttpSession httpSession) {

        ModelAndView getAllMyTasks = new ModelAndView("myTasksList");

        Long staffId = (Long) httpSession.getAttribute("UserId");

        List<ProjectTask> projectTaskList = projectTaskService.findAllProjectTasksByStaff(staffId);

        getAllMyTasks.addObject("projectTaskList", projectTaskList);

        return getAllMyTasks;

    }

    @RequestMapping(value = "/view/{projectTaskId}", method = RequestMethod.GET)
    public ModelAndView getMyTaskView(@PathVariable Long projectTaskId, HttpSession httpSession) {

        ModelAndView getMyTaskView = new ModelAndView("myTaskView");

        ProjectTask projectTask = projectTaskService.getProjectTaskById(projectTaskId);

        List<TaskMessage> taskMessageList = new ArrayList<>(projectTask.getTaskMessages());
        TaskMessage firstTaskMEssage = taskMessageList.get(taskMessageList.size()-1);

        Collections.sort(taskMessageList, new TaskMessageByDateComparator());

        getMyTaskView.addObject("projectTask", projectTask);
        getMyTaskView.addObject("firstTaskMEssage", firstTaskMEssage);
        getMyTaskView.addObject("taskMessageList", taskMessageList);

        return getMyTaskView;
    }

    @RequestMapping(value = "/write-task-message" ,method = RequestMethod.POST)
    public ModelAndView writeMessage(@RequestParam("projectTask_id") Long projectTaskId,
                                     @RequestParam("text") String text ,
                                     @RequestParam("file[]") MultipartFile[] multipartFile,
                                     HttpSession httpSession){

        StaffInfo staffInfo = (StaffInfo) httpSession.getAttribute("staffInfo");

        ProjectTask projectTask = projectTaskService.getProjectTaskById(projectTaskId);

        TaskMessage taskMessage = new TaskMessage(projectTask, staffInfo.getUser(), text, new Date(), staffInfo.getName(), new HashSet<>());

        taskMessageService.addNewTaskMessage(taskMessage);

        SaveFile saveFile = new SaveFile(multipartFile);
        saveFile.saveToTaskMessageFiles(taskMessage);

        taskMessageService.updateTaskMessage(taskMessage);

        return new ModelAndView("redirect:/my-tasks/view/" + projectTaskId);
    }

}
