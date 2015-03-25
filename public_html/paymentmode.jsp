<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="../Styles/Expenses.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>paymentmode</title>
  </head>
  <body>
   <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="addpaymentmode?action=com.expensetracker.action.AddPaymentMode" method="POST">
      <p>NEW/EDIT - PAYMENT MODE</p>
      <p>&nbsp;</p>
      <table cellspacing="2" cellpadding="3" border="0" width="70%">
        <tr>
          <td>Name</td>
          <td>
            <input type="text" name="name" maxlength="20" size="20"/>
          </td>
        </tr>
        <tr>
          <td>Card No</td>
          <td>
            <input type="text" name="cardno" maxlength="16" size="16"/>
          </td>
        </tr>
        <tr>
          <td>Account No</td>
          <td>
            <input type="text" name="accountno" maxlength="20" size="20"/>
          </td>
        </tr>
        <tr>
          <td>Created by </td>
          <td>
            <input type="text" name="createdby" maxlength="30" size="30"/>
          </td>
          <td>on</td>
          <td>
            <input type="text" name="created" maxlength="50" size="50"/>
          </td>
        </tr>
        <tr>
          <td>Last Modified date</td>
          <td>
            <input type="text" name="updated" maxlength="50" size="50"/>
          </td>
        </tr>
        <tr>
          <td>
            <input type="submit" name="submit" value="Submit"/>
          </td>
          <td>
            <input type="reset" name="Cancel" value="Cancel"/>
          </td>
        </tr>
      </table>
    </form></body>
</html>