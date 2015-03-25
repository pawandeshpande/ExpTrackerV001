<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.PaymentMode,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>

<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>PaymentModeList</title>
  </head>
  <body>
   <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="adduser" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Payment Mode List</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center" border="1">
        <tr>
        <td></td>
          <td>Name:</td>
          <td>Credit Card Number</td>
          <td>Bank Account Number</td>
          <td>Create By</td>
          <td>Created On</td>
          </tr>
        <%
                List<PaymentMode> pmodeList=(List<PaymentMode>)request.getAttribute(ExpenseTrackerConstants.SESSION_PAYMENTMODE_LIST);
        Iterator<PaymentMode> itr=pmodeList.iterator();
        while(itr.hasNext()){
            PaymentMode p=itr.next();
      %>
        <tr>
        <td><a href="#">Edit</a>&nbsp;<a  href="javascript:void(0);" OnClick="DeletePaymentMode(<%=p.getRowId()%>);" >Remove</a></td>
          <td><%= p.getName()%> </td>
          <td><%= p.getCardNo()%></td>
          <td><%= p.getAccountNo()%></td>
          <td><%=p.getUser().getName()%></td>
          <td><%=p.getCreated()%></td>
          <td><input type="checkbox" name="defaultcheck" value="&nbsp;"  checked='<%=((p.getDefaultFlg()!=null)&&(p.getDefaultFlg().compareTo("Y")==0))?"checked":"unchecked"%>'
                     disabled="disabled" ></td>
          
          </tr>
          <%}%>          
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="New Payment Mode" onclick="document.expenseform.action='paymentmodelistservlet?action=com.expensetracker.action.PaymentModeListServlet&do=ADD';document.expenseform.submit();"></input>
            &nbsp;
            
            &nbsp;          
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>