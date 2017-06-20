<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.SoftwareFactoryStaff.model.ProjectTask" %>
<%@ page import="java.util.List" %>
<%@ page import="com.SoftwareFactoryStaff.constant.ProjectEnum" %>
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
    <%List<ProjectTask> projectTaskList = (List<ProjectTask>)request.getAttribute("projectTaskList");%>

    <%@ include file="leftCategoriesMenu.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <!-- Header -->
        <header class="header line">
            <a href="javascript:void(0);" class="btn btn-toggle" id="menu-toggle"><i class="fa fa-list" aria-hidden="true"></i></a>
            <span class="header-title clearfix">All task list</span>
        </header>
        <!-- #End Header -->

        <section class="content container-fluid">
            <div class="background-01">

                <table id="dataTable" class="table" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Project name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Project name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                    </tr>
                    </tfoot>
                    <!-- Items list -->
                    <tbody>
                    <%for (ProjectTask projectTask : projectTaskList){%>
                        <%if (projectTask.getWorkingStaffID() == null){%>
                            <tr>
                                <td align="center"><%out.print(projectTask.getId());%></td>
                                <td><a href="<%out.print("/all-tasks/view/"+projectTask.getId()+"/");%>"><%out.print(projectTask.getTitle());%></a></td>
                                <td align="center">
                                    <% if (projectTask.getProject().getProjectName().equals(ProjectEnum.projectNameNormal.getDbValue())) {
                                        out.print(ProjectEnum.projectNameNormal.getValue());
                                    }else if (projectTask.getProject().getProjectName().equals(ProjectEnum.projectNameEstimate.getDbValue())) {
                                        out.print(ProjectEnum.projectNameEstimate.getValue());
                                    } else out.print(projectTask.getProject().getProjectName()); %>
                                </td>
                                <td align="center"><%out.print(dateFormatShow.format(projectTask.getStartDate()));%></td>
                                <td align="center"><%out.print(dateFormatShow.format(projectTask.getEndDate()));%></td>
                            </tr>
                        <%}%>
                    <%}%>
                    </tbody>
                    <!-- #End Items list -->
                </table>
            </div>
        </section>
    </div>
    <!-- #End Page Content -->

</div>
<!-- #End Wrapper -->

<%@ include file="javascript.jsp" %>

</body>
</html>