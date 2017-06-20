<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryStaff.model.ProjectTask" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryStaff.constant.ProjectEnum" %>
<%@ page import="com.SoftwareFactoryStaff.model.TaskMessage" %>
<%@ page import="com.SoftwareFactoryStaff.model.TaskMessageLink" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.SoftwareFactoryStaff.comparator.TaskMessageByDateComparator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no, minimal-ui"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="format-detection" content="address=no"/>

    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <title>View task :: 소프트웨어팩토리</title>

    <%@ include file="styles.jsp" %>

</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <%SimpleDateFormat dateFormatShow = new SimpleDateFormat("yyyy-MM-dd HH:mm");%>
    <%ProjectTask projectTask = (ProjectTask)request.getAttribute("projectTask");%>
    <%TaskMessage firstTaskMEssage = (TaskMessage)request.getAttribute("firstTaskMEssage");%>
    <%List<TaskMessage> taskMessageList = (List<TaskMessage>)request.getAttribute("taskMessageList");%>

    <%@ include file="leftCategoriesMenu.jsp" %>


    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-bars" aria-hidden="true"></i></a>
            <span class="header-title clearfix">Task: <%out.print(projectTask.getTitle());%></span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">

            <div class="row">
                <div class="mb10">
                    <a href="/my-tasks/" class="btn btn-default"><i class="fa fa-times-circle pr5"></i> Cancel & Back</a>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-7">
                    <div class="background-01">
                        <div class="scrollable">

                            <%if (taskMessageList.size()>0){%>
                                <%for (TaskMessage taskMessage : taskMessageList){%>
                                    <%if (taskMessage.getUser().getId() == staffInfo.getId()){%>
                                        <div class="message-right">
                                            <div class="clearfix message-header">
                                                <div class="title"><%out.print(taskMessage.getSenderName());%></div>
                                                <div class="date"><%out.print(dateFormatShow.format(taskMessage.getDate()));%></div>
                                            </div>
                                            <%out.print(taskMessage.getMessageText());%>
                                            <%if (taskMessage.getTaskMessageLinks().size()>0){%>
                                                <%for (TaskMessageLink taskMessageLink : taskMessage.getTaskMessageLinks()){%>
                                                    <p><a href="<%out.print(taskMessageLink.getFileLink());%>"><%out.print(taskMessageLink.getFileName());%></a></p>
                                                <%}%>
                                            <%}%>
                                        </div>
                                    <%} else {%>
                                        <div class="message-left">
                                            <div class="clearfix message-header">
                                                <div class="title"><%out.print(taskMessage.getSenderName());%></div>
                                                <div class="date"><%out.print(dateFormatShow.format(taskMessage.getDate()));%></div>
                                            </div>
                                            <%out.print(taskMessage.getMessageText());%>
                                            <%if (taskMessage.getTaskMessageLinks().size()>0){%>
                                                <%for (TaskMessageLink taskMessageLink : taskMessage.getTaskMessageLinks()){%>
                                                    <p><a href="<%out.print(taskMessageLink.getFileLink());%>"><%out.print(taskMessageLink.getFileName());%></a></p>
                                                <%}%>
                                            <%}%>
                                        </div>
                                    <%}%>
                                <%}%>
                            <%}%>
                        </div>
                    </div>


                </div>

                <div class="col-sm-5">
                    <div class="background-01">

                        <form class="form-horizontal" action="/my-tasks/write-task-message/" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="projectTask_id" value="<%out.print(projectTask.getId());%>">
                            <h4>Write message</h4>
                            <!-- FULL TASK DESCRIPTION -->
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <textarea id="editor" name="text" rows="3"></textarea>
                                </div>
                            </div>
                            <!-- #End FULL TASK DESCRIPTION -->

                            <div class="form-group">
                                <!-- Attach files -->
                                <label class="col-sm-3 control-label">Attach File</label>
                                <div class="col-sm-9">
                                    <input id="uploadFile" name="file[]" multiple type="file">
                                </div>
                                <!-- #End Attach files -->
                            </div>

                            <div class="form-group">
                                <div class="col-sm-12" align="right">
                                    <button type="submit" name="save" class="btn btn-primary right"><i
                                            class="fa fa-envelope-o" aria-hidden="true"></i> Send
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row mt20">
                <div class="col-sm-4" style="height: auto;">
                    <div class="background-01">
                        <span class="content-title mt30">Task information</span>
                        <p>Title: <%out.print(projectTask.getTitle());%></p>
                        <p>Project name:
                            <% if (projectTask.getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                out.print(ProjectEnum.projectNameNormal.getValue());
                            }else if (projectTask.getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                out.print(ProjectEnum.projectNameEstimate.getValue());
                            } else out.print(projectTask.getProject().getProjectName()); %>
                        </p>
                        <p>Start date: <%out.print(dateFormatShow.format(projectTask.getStartDate()));%></p>
                        <p>End date: <%out.print(dateFormatShow.format(projectTask.getEndDate()));%></p>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="background-01">
                        <span class="content-title mt30">Full task description</span>
                        <div class="mb20">
                            <%out.print(firstTaskMEssage.getMessageText());%>

                            <%if (firstTaskMEssage.getTaskMessageLinks().size()>0){%>
                                <h4>Attach file</h4>
                                <div class="mb20">
                                    <%for (TaskMessageLink taskMessageLink : firstTaskMEssage.getTaskMessageLinks()){%>
                                        <p><a href="<%out.print(taskMessageLink.getFileLink());%>"><%out.print(taskMessageLink.getFileName());%></a></p>
                                    <%}%>
                                </div>
                            <%}%>

                        </div>
                    </div>
                </div>
            </div>


        </section>


    </div>
    <!-- #End Page Content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>