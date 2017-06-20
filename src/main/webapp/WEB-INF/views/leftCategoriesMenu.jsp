<%@ page import="com.SoftwareFactoryStaff.model.StaffInfo" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<!-- Sidebar -->
<div id="sidebar-wrapper">

    <% StaffInfo staffInfo =  (StaffInfo)request.getSession().getAttribute("staffInfo");%>

    <aside class="sidebar-nav">

        <!-- Logo -->
        <div class="logo"><a href="/">소프트웨어<span>팩토리</span></a></div>
        <!-- #End Logo -->

        <!-- Customer -->
        <div class="customer">

            <div class="cust-thumbnail"><a href="javascript:void(0);"><img src="http://placehold.it/150x150" class="img-circle" alt=""></a></div>
            <div class="information">
                <a href="javascript:void(0);">
                    <%if (staffInfo != null){
                        out.print(staffInfo.getName());
                    }else {
                        response.sendRedirect("/");
                    }%>
                </a>
            </div>
            <div class="settings">
                <a href="/settings/"><i class="fa fa-cogs"></i> Settings</a>
                <a href="<c:url value="/logout" />"><i class="fa fa-sign-out"></i> Log Out</a>
            </div>

        </div>
        <!-- #End Customer -->


        <%HttpSession session = request.getSession();%>
        <%if (session != null){ %>
        <!-- Left categories -->
            <ul>
                <li><a href="/all-tasks/"><i class="fa fa-list" aria-hidden="true"></i> All tasks list</a></li>
                <li><a href="/my-tasks/"><i class="fa fa-file-code-o" aria-hidden="true"></i> My tasks</a></li>
            </ul>
        <!-- #End Left categories -->
        <%}else{
            response.sendRedirect("/list");
        }%>

        <div class="copyright">2017 &copy; Software Factory</div>
    </aside>

</div>
<!-- #End Sidebar -->

