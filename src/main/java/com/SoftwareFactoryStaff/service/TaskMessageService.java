package com.SoftwareFactoryStaff.service;


import com.SoftwareFactoryStaff.model.TaskMessage;

import java.util.List;

public interface TaskMessageService {

    void addNewTaskMessage(TaskMessage taskMessage);

    void updateTaskMessage(TaskMessage taskMessage);

    void deleteTaskMessage(TaskMessage taskMessage);

    List<TaskMessage> getAllTaskMessages();

    TaskMessage getTaskMessageById(Long id);

}
