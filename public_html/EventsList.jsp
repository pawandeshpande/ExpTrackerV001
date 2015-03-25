<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.Event,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>

<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>EventsList</title>
  </head>
  <body>
   <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="#" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Accounts/Events</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center" border="1">
        <tr>
        <td></td>
          <td>Name:</td>
          <td>Create By</td>
          <td>Updated By</td>
          <td>Created:</td>
          </tr>
        <%
                List<Event> lEvent=(List<Event>)request.getAttribute(ExpenseTrackerConstants.SESSION_EVENT_LIST);
        Iterator<Event> itr=lEvent.iterator();
        while(itr.hasNext()){
            Event evt=itr.next();
      %>
        <tr>
        <td><a href="javascript:void(0);" OnClick="doSubmit('Accountslistservlet?do=edit&id=<%=evt.getRowId()%>&action=com.expensetracker.action.EventListAction');">Edit</a>&nbsp;<a  href="javascript:void(0);" OnClick="DeleteEvent(<%=evt.getRowId()%>);" >Remove</a></td>
          <td><%= evt.getName()%> </td>
          <td><%=session.getAttribute(ExpenseTrackerConstants.SESSION_USER_NAME)%></td>
         
          <td><%= evt.getUser1().getName()%></td>
          <td><%=evt.getCreated()%></td>
          </tr>
          <%}%>
          </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Add" onclick="document.expenseform.action='AddAccount?action=com.expensetracker.action.EventListAction&do=ADD';document.expenseform.submit();"></input>
            &nbsp;
           
            &nbsp;          
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>