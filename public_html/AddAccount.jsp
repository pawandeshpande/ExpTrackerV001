<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"
         import="com.expensetracker.ExpenseTrackerConstants"%>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="M:\Styles\Expenses.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>AddEvent</title>
   
  </head>
  <body>
  
    <%@ include file="/TopFrame.jsp"%>
     
    <form name="expenseform" action="addexpense?action=com.expensetracker.action.AddAccount" method="POST">
     
      <table>
        <tr>
          <td align="center">
            <h2>
              <u>Add Account</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center">
        <tr>
          <td>Name:</td>
          <td>
            <input type="text" name="eventname" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Created:</td>
          <td>
            <input type="text" name="created" size="20" maxlength="30"
                   readonly="readonly"
                   value='<%=session.getAttribute(ExpenseTrackerConstants.SESSION_USER_NAME)%>'></input>
          </td>
        </tr>
        <tr>
          <td>Updated:</td>
          <td>
            <input type="text" name="updated" size="20" maxlength="30"
                   readonly="readonly"></input>
          </td>
        </tr>
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Save Account"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
            <input type="button" value="Go Back"
                   onclick="document.expenseform.action='eventslistservlet';document.expenseform.submit();"></input>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>