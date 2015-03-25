<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.Borrower,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="Styles/Expenses.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>BorrowerList</title>
  </head>
  <body>
  <form name="expenseform" action="adduser" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Borrower'S List</u>
            </h2>
          </td>
        </tr>
      </table>
      <table align="center" border="1">
        <tr>
        <td></td>
          <td>First Name</td>
          <td>Last Name</td>
          <td>Address</td>
          <td>Created</td>
          <td>Updated</td>
          </tr>
        <%
        List<Borrower> lborrower=(List<Borrower>)request.getAttribute(ExpenseTrackerConstants.SESSION_BORROWER_LIST);
        Iterator<Borrower> itr=lborrower.iterator();
        while(itr.hasNext()){
            Borrower br=itr.next();
      %>
        <tr>
        <td><a href="#">Edit</a>&nbsp;<a href="#">Remove</a></td>
          <td><%= br.getFirstname()%> </td>
          <td><%= br.getLastname()%> </td>
          <td><%= br.getAddress()%> </td>
          <td><%= br.getCreated()%> </td>
          <td><%= br.getUpdated()%> </td>
          </tr>
          <%}%>          
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Add New Borrower" onclick="document.expenseform.action='AddBorrower.jsp';document.expenseform.submit();"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
            <input type="button" value="Back to Dashboard" onclick="document.expenseform.action='ExpensesDashboard.jsp';document.expenseform.submit();"></input>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>