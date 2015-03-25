<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>AddUser</title>
    
    
  </head>
  <body >
   <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="adduser" method="POST">
      <table border="0" cellpadding="0" align="center" cellspacing="0">
        <tr>
          <td align="center">
            <h2>
              <u>Add User</u>
            </h2>
          </td>
        </tr>
      </table>
      <table border="1" cellpadding="0" align="center" cellspacing="0">
        <tr>
          <td>Name:</td>
          <td>
            <input type="text" name="name" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>User SignIn Name:</td>
          <td>
            <input type="text" name="username" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Password:</td>
          <td>
            <input type="password" name="password" size="20" maxlength="30"></input>
          </td>
        </tr>
         <tr>
          <td>Confirm Password:</td>
          <td>
            <input type="password" name="confirm_password" size="20" maxlength="30"></input>
          </td>
        </tr>
        
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Save User" onclick="return ValidatePassword();"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
            <input type="button" value="Go Back" onclick="document.expenseform.action='userlistservlet';document.expenseform.submit();"></input>          
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>