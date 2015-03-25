<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.expensetracker.bean.*,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>
<%@ page import="java.sql.Timestamp,java.util.Date"%>


<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="../Styles/Expenses.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>AddExpensesType</title>
  </head>
  <body>
  
   <%@include file="/TopFrame.jsp"%>
 
    <form name="expenseform" action="AddExpenseType?action=com.expensetracker.action.AddExpenseType" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Add Expense Type</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center">
        <tr>
          <td>Name:</td>
          <td>
            <input type="text" name="expensetypename" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Description:</td>
          <td>
            <textarea cols="20" rows="5" name="desc"></textarea>
          </td>
        </tr>
        <tr>
          <td>
            <p/>
            <p>
              Default
            </p>
          </td>
          <td>
            <input type="checkbox" name="DefaultFlag" value="N"
                   id="defaultcheck" tabindex="3"/>
          </td>
        </tr>
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Save Expense Type"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>