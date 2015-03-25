<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252" import="com.expensetracker.ExpenseTrackerConstants" %>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="Styles/Expenses.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>AddBorrower</title>
  </head>
  <body>
  <form name="expenseform" action="addborrower" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Add Borrower</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center" border="1">
        <tr>
          <td>First Name:</td>
          <td>
            <input type="text" name="firstname" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Last Name:</td>
          <td>
            <input type="text" name="lastname" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Address:</td>
          <td>
            <input type="text" name="address" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Created:</td>
          <td>
            <input type="text" name="created" size="20" maxlength="30"
                   readonly="readonly" value='<%=session.getAttribute(ExpenseTrackerConstants.SESSION_USER_NAME)%>'></input>
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
            <input type="submit" value="Save Borrower"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
            <input type="button" value="Go Back" onclick="document.expenseform.action='borrowerlist';document.expenseform.submit();"></input>          
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>