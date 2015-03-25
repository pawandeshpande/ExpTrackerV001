<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.User,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants,com.expensetracker.bean.SessionEJB,com.expensetracker.util.EMFactory"%>
 <html>
  <head>
  <link rel="stylesheet" type="text/css" href="../Styles/Expenses.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>TopFrame</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    
    <script language="javascript" type="text/javascript" src="../scripts/exptracker.js">
    </script>   
  </head>

  <body>
  <form name="topFrameForm" action="#" method="post">
  <input type="hidden" name="signout">  
  <%
  HttpSession hSession = request.getSession();
       String username = (String) hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER_NAME);
       if(username!=null){
       System.out.println("Current Username = "+ username + "\n");
       }
       
  %>
  <table>
    <tr>
    <td width="90%">
       <ul id="tabnav">
	<li class="tab1"><a href="javascript:void(0);" onclick="doSubmit('ExpenseListAction?action=com.expensetracker.action.ExpenseListAction');" >Expenses</a></li>
       <%
       if(username!=null && username.equals("Administrator"))
       {
       %>
       <li class="tab2"><a href="javascript:void(0);" onClick="doSubmit('UserListServlet?action=com.expensetracker.action.UserListAction');" >Users</a></li>
       <%}%> 

	<li class="tab3"><a href="javascript:void(0);" onClick="doSubmit('EventListAction?action=com.expensetracker.action.EventListAction');">Accounts</a></li>
	<li class="tab4"><a href="javascript:void(0);" onClick="doSubmit('ExpenseTypeListAction?action=com.expensetracker.action.ExpenseTypeListAction');">Expense Types</a></li>
        <li class="tab5"><a href="javascript:void(0);" onClick="doSubmit('PaymentModeListAction?action=com.expensetracker.action.PaymentModeListAction');">Payment Modes</a></li>
        <li class="tab6"><a href="javascript:void(0);" onClick="doSubmit('ReportAction?action=com.expensetracker.action.ReportAction');">Reports</a></li>
        

        </ul>
    </td>
     <%  
     if(username.equals("Administrator"))
       {
       %>
         <td align="right"><a href="#">Admin</a></td> 
         <%}%>
    <td align="right"><a href="javascript:void(0);" onClick="doSubmit('loginservlet?signout=true&action=com.expensetracker.action.LoginAction')">SignOut</a></td>
    </tr>
  </table>
  </form>
  </body>
</html>