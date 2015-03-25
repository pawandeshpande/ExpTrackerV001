<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252" import="com.expensetracker.ExpenseTrackerConstants" %>
<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>AddPaymentMode</title>
    
    
    
  </head>
  <body>
   <%@include file="/TopFrame.jsp"%>
    <form name="expenseform" action="addpaymentmode" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Add Payment Mode</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center">
        <tr>
          <td>Option:</td>
          <td>
             <select name="PaymentModeOption">
             <option value="Cash">Cash</option>
             <option value="Cheque">Cheque</option>
             <option value="Credit Card"  onclick="ProcessCreditCardOption();">Credit Card</option>
             <option value="Coupons">Coupons</option>
             </select>
             </td>
             
        </tr>
        <tr>
        <td>Name:
        </td>
        <td>
            <input type="text" name="name" size="20" maxlength="30"
                  ></input>
          </td>
          <td>Credit Card No:</td>
          <td>
            <input type="text" name="creditcardno" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Account No:</td>
          <td>
            <input type="text" name="accountno" size="20" maxlength="30"></input>
          </td>
        </tr>
        <tr>
          <td>Default</td>
          <td>
            <input type="checkbox" name="DefaultFlag" value="Y"
                   style="color:Black;"/>
          </td>
        </tr>
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Save Payment Mode"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
            <input type="button" value="Go Back" onclick="document.expenseform.action='paymentmodelist';document.expenseform.submit();"></input>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>