<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.Expenses,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>

<html>
  <head>
    <link type="text/css" rel="stylesheet" href="../Styles/Expenses.css"/>
    
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>UsersList</title>
      
  </head>
  <body>
  <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="#" method="POST">
            <h2>
              <u>
                Expense List - Recent 15 expenses.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" value="Add New Expense"
                 onclick="document.expenseform.action='loadexpensespageservlet?action=com.expensetracker.action.LoadExpensePageAction&do=ADD';document.expenseform.submit();"
                 id="btnAddExpense" name="btnAddExpense"/>

        </u>
            </h2>
      <table>
      <thead>
        <tr>
        <th>&nbsp;</th>
          <th>Name</th>
          <th>Total Amount</th>
          <th>Description</th>
          <th>Payment Mode</th>
          <th>Bill/Transaction No.</th>
          <th>Bill Date</th>
          <th>Account</th>
          <th>Expense Type</th>
          <th>Comments</th>          
          <th>Created By</th>
          <th>Created On</th>
          <th>Updated By</th>
        </tr>
        <tbody> 
        
        <%
        List<Expenses> lstExpenses=(List<Expenses>)request.getAttribute(ExpenseTrackerConstants.SESSION_EXPENSE_LIST);
        if(lstExpenses!=null){
        int i = 0; 
        Iterator<Expenses> itr=lstExpenses.iterator();
         while(itr.hasNext() && i<=15){
            Expenses exp=itr.next();
        if(i%2 == 0){
        %>
        <tr class="even">
        <%
        }
        else
        {
        %><tr class="odd"><%}%>
        <td><a href="javascript:void(0);" OnClick="doSubmit('expenselistservlet?do=edit&id=<%=exp.getRowId()%>&action=com.expensetracker.action.ExpenseListAction');">Edit</a>&nbsp;<a  href="javascript:void(0);" OnClick="DeleteExpense(<%=exp.getRowId()%>);" >Remove</a></td>
          <td><%= exp.getName()%> </td>
          <td><%= exp.getTotalAmt()%> </td>
          <td><%= exp.getDescription()%> </td>
          <td><%= (exp.getPaymentMode())!=null?exp.getPaymentMode().getName():""%> </td>
          <td><%= exp.getBillNo()%> </td>
               
          <td><%= exp.getBillDate()%> </td>
          <td><%= (exp.getEvent()!=null)?exp.getEvent().getName():""%> </td>
          <td><%= (exp.getExpenseType())!=null?exp.getExpenseType().getName():""%> </td>
          <td><%= exp.getComments()%> </td>
          <td><%= exp.getUser().getName()%></td>
          <td><%=exp.getCreated() %></td>
          <td><%=(exp.getUser1())!=null?exp.getUser1():""%></td>
          </tr>
          <%
          i++;
          }
          }%>
          </table>
       </form>
  </body>
</html>