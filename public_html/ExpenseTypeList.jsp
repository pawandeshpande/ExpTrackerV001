<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.ExpenseType,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>

<html>
  <head>
  
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Expense Types List page</title>
  </head>
  <body>
   <%@include file="/TopFrame.jsp"%>
  <form name="expenseform" action="adduser" method="POST">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Expense Types List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="New Expense Type"
                       onclick="document.expenseform.action='AddExpenseType?action=com.expensetracker.action.ExpenseTypeListAction&do=ADD';document.expenseform.submit();"/>
              </u>
            </h2>
          </td>
        </tr>
      </table>
      <table>
        <thead>
        <tr>
        <td>&nbsp;</td>
          <td>Name:</td>
          <td>Description</td>
          <td>Default</td>
          <td>Created By</td>
          <td>Created On</td>
          </tr>
          </thead>
        <%
                List<ExpenseType> expenseTypeList=(List<ExpenseType>)request.getAttribute(ExpenseTrackerConstants.SESSION_EXPENSETYPE_LIST);
        if(expenseTypeList!=null){
        Iterator<ExpenseType> itr=expenseTypeList.iterator();
        int i =0; 
        while(itr.hasNext()){
            ExpenseType et =itr.next();
        
        
      %>
      <tr>
        
        <td><a href="#">Edit</a>&nbsp;<a href="#">Remove</a></td>
          <td><%= et.getName()%> </td>
          <td><%= et.getDescription()%></td>
          
          <td><input type="checkbox" name="defaultcheck" value="&nbsp;"  checked='<%=((et.getDefaultFlg()!=null)&&(et.getDefaultFlg().compareTo("Y")==0))?"checked":"unchecked"%>'
                     disabled="disabled" ></td>
                  
          <td><%= et.getUser().getName()%></td>
          <td><%= et.getCreated()%></td>
          </tr>
          <%
          i++;
          }
          }%>          
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            &nbsp;
            
            &nbsp;          
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>