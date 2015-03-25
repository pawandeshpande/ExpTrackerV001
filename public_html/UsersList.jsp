<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.User,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants,com.expensetracker.bean.SessionEJB,com.expensetracker.util.EMFactory"%>

<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>UsersList</title>
  </head>
  <body>
   <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="adduser" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>User'S List</u>
            </h2>
          </td>
        </tr>
      </table>
      <table >
        <tr>
        <td></td>
          <td>Name:</td>
          <td>User SignIn Name:</td>
          <td>Created:</td>
          <td>Updated:</td>
          </tr>
        <%
        List<User> luser=(List<User>)request.getAttribute(ExpenseTrackerConstants.SESSION_USER_LIST);
        Iterator<User> itr=luser.iterator();
        int i =0; 
        while(itr.hasNext()){
            User u=itr.next();
            if(i%2==0)
            {
      %>
        <tr bgcolor="#f5daff">
        <%}else {%>
        <tr bgcolor="#d3aaff">
        <%}%>
        <td><a href="/edituserservlet">Edit</a>&nbsp;<a href="/removeuserservlet">Remove</a></td>
          <td><%= u.getName()%> </td>
          <td><%= u.getUsername()%></td>
          <td><%=u.getCreatedBy()%></td>
          <td><%=u.getUpdatedBy()%></td>
          <td>
          
          
          <input type="hidden" name="userid" id='<%=u.getRowId()%>' value='<%=u.getRowId()%>'></td>
          </tr>
          <%
          i++;
          }
         %>  
         
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Add New User" onclick="document.UsersListForm.action='AddUser.jsp';document.expenseform.submit();"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>