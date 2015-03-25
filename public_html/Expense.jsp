<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.expensetracker.bean.*,java.util.List,java.util.Iterator,com.expensetracker.ExpenseTrackerConstants"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <script type="text/javascript" language="javascript" src="../scripts/ts_picker.js"></script>
    <title>New Expense</title>
  </head>
  <body>
    <%@ include file="/TopFrame.jsp"%>
     
    <form name="expenseform" method="post" action="addexpense?action=com.expensetracker.action.AddExpense">
      <table width="100%">
        <tr>
          <td align="center">
            <h2>
              <u>Add Expense</u>
            </h2>
          </td>
        </tr>
      </table>
      <table cellpadding="0" cellspacing="0" border="1" align="center">
        <tr>
          <td>Account:</td>
          <td>
            <select name="eventname">
              <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
              <%
        List<Event> lEvent=(List<Event>)request.getAttribute(ExpenseTrackerConstants.SESSION_EVENT_LIST);
        if(lEvent!=null)
        {
          Iterator<Event> itr=lEvent.iterator();
        while(itr.hasNext()){
            Event evt=itr.next();
            
      %>
              <option value="<%=evt.getRowId()%>">
                <%=evt.getName()%>
              </option>
              <%
              }
              }
              %>
            </select>
          </td>
        </tr>
        <tr>
          <td>Expense Type:</td>
          <td>
            <select name="expensetype">
              <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
              <%
            
        List<ExpenseType> lExpenseType=(List<ExpenseType>)request.getAttribute(ExpenseTrackerConstants.SESSION_EXPENSETYPE_LIST);
        if(lExpenseType!=null){
        Iterator<ExpenseType> itrEType=lExpenseType.iterator();
        while(itrEType.hasNext()){
            ExpenseType eType=itrEType.next();
             %>
              <option value="<%=eType.getRowId()%>">
                <%=eType.getName()%>
              </option>
              <%
              }
              }
              %>
            </select>
          </td>
        </tr>
        <tr>
          <td>Name:</td>
          <td>
            <input type="text" name="ExpenseName" maxlength="30" size="20"
                   value=""/>
          </td>
        </tr>
        <tr>
          <td>Amount:</td>
          <td>
            <input type="text" name="amount" maxlength="10" size="10"
                   onchange="return CalculateTax();"
                   value=""/>
          </td>
        </tr>
        <tr>
          <td>Tax:</td>
          <td>
            <input type="text" name="tax" maxlength="2" size="2"
                   onchange="return CalculateTax();"
                   value=""/>
            &nbsp;%
          </td>
        </tr>
        <tr>
          <td>Total Amount:</td>
          <td>
            <input type="text" name="totalamount" maxlength="10" size="10"
                   value=""/>
          </td>
        </tr>
        <tr>
          <td>Description:</td>
          <td>
            <textarea name="desc" cols="20" rows="2"
                      value=""></textarea>
          </td>
        </tr>
        <tr>
          <td>Payment Mode:</td>
          <td>
            <select name="paymentmode">
              <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
              <%
           
        List<PaymentMode> lPaymentMode=(List<PaymentMode>)request.getAttribute(ExpenseTrackerConstants.SESSION_PAYMENTMODE_LIST);
        if(lPaymentMode!=null){
        Iterator<PaymentMode> itrPMode=lPaymentMode.iterator();
        while(itrPMode.hasNext()){
            PaymentMode pMode=itrPMode.next();
            %>
              <option value="<%=pMode.getRowId()%>">
                <%=pMode.getName()%>
              </option>
              <%
              }
              }
              %>
            </select>
          </td>
        </tr>
        <tr>
          <td>Bill/Transaction no:</td>
          <td>
            <input type="text" name="billno" maxlength="30" size="10"
                   value=""/>
          </td>
        </tr>
        <tr>
          <td>Bill date:</td>
          <td>
            <input type="text" alt="yyyy-mm-dd" name="billdate" maxlength="30" size="10"
                   value="">yyyy-mm-dd</input>
    
    
<!--<a href="javascript:void(0);"  OnClick="javascript:show_calendar('document.expenseform.billdate', document.expenseform.billdate.value);">
          <img src="../images/cal.gif" width="16" height="16" border="0"></img>
    </a>-->
                   
          </td>
          <!--<td><div id="innerCalendar" ><p>calendar<p></div></td>-->
        </tr>
        <!-- Borrower section is deleted from here. Will add borrower support in future.-->
        <tr>
          <td>Comments:</td>
          <td>
            <textarea name="comments" cols="20" rows="2" ></textarea>
          </td>
        </tr>
      </table>
      <table width="100%">
        <tr align="center">
          <td>
            <input type="submit" value="Save Expense" onclick="CalculateTax();"></input>
            &nbsp;
            <input type="reset" value="Reset"></input>
            &nbsp;
            <input type="button" value="Go Back"
                   onclick="document.expenseform.action='expenselistservlet';document.expenseform.submit();"></input>
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>