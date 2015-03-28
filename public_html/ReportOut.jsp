<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@page import="com.expensetracker.bean.Expenses,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>

<html>
  <head>
    <link type="text/css" rel="stylesheet" href="../Styles/Expenses.css"/>
    
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>Report</title>
      
  </head>
  <body>
 
  <%! double TotalAmount = 0.00;
     
     String txtExportExcel = request.getParameter("exportToExcel");
        if (txtExportExcel != null
                && txtExportExcel.toString().equalsIgnoreCase("YES")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename="
                    + "excel.xls");
 
        }
    %>

  <form name="expenseform" action="#" method="POST">
            <h2>
              <u>
                Report of expenses.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </u>
            </h2>
      <table>
      <thead>
        <tr>
        
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
        </thead>
        <tbody> 
        <%
        List<Expenses> lstExpenses=(List<Expenses>)request.getAttribute(ExpenseTrackerConstants.SESSION_EXPENSE_LIST);
        if(lstExpenses!=null){
        TotalAmount=0.0;
        Iterator<Expenses> itr=lstExpenses.iterator();
         while(itr.hasNext()){
            Expenses exp=itr.next();
        %>
        <tr>
        
          <td><%= exp.getName()%>&nbsp; </td>
          <td><%= exp.getTotalAmt()%> &nbsp;</td>
          <td><%= exp.getDescription()%>&nbsp; </td>
          <td><%= (exp.getPaymentMode())!=null?exp.getPaymentMode().getName():""%> &nbsp;</td>
          <td><%= exp.getBillNo()%>&nbsp; </td>
          <td><%= exp.getBillDate()%> &nbsp;</td>
          <td><%= (exp.getEvent()!=null)?exp.getEvent().getName():""%> &nbsp;</td>
          <td><%= (exp.getExpenseType())!=null?exp.getExpenseType().getName():""%>&nbsp; </td>
          <td><%= exp.getComments()%> &nbsp;</td>
          <td><%= exp.getUser().getName()%>&nbsp;</td>
          <td><%=exp.getCreated()%>&nbsp;</td>
          <td><%=(exp.getUser1())!=null?exp.getUser1():""%>&nbsp;</td>
          </tr>
          <%
          
          TotalAmount += exp.getTotalAmt().doubleValue(); 
          
          }
          }%>
          
          <tr>
          <td>
              <h2>
                <strong><font color="#2121ff">
                    Total Rs. 
                  </font></strong>
              </h2>
          </td>
          <td>
              <h2>
                <strong><font color="#2121ff">
                    <%=TotalAmount%>
                  </font></strong>
                
              </h2>
          
          </td>
          </tr>
          
          </tbody>
          
          </table>
       </form>
  </body>
</html>