<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ page import="com.expensetracker.ExpenseTrackerConstants"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>login</title>
    <script language="javascript" type="text/javascript">
    function doValidate(){
    document.getElementById("InvCredMessage").style.visibility="hidden";
      var status = document.expenseform.invaliduser.value; 
      if(status!=undefined && status== "true"){
        document.getElementById("InvCredMessage").style.visibility="visible";
      }
    }
    </script>
  </head>
  <body onload="doValidate();">
    <p>
      &nbsp;
    </p><p>
      &nbsp;
    </p><p>
      &nbsp;
    </p><p>
      &nbsp;
    </p><form name="expenseform" method="POST" action="user/loginservlet?cLogin">
     
      <input type="hidden" name="invaliduser"
             value='<%=request.getAttribute(ExpenseTrackerConstants.SESSION_INVALID_CREDENTIALS)%>'>
      <table cellspacing="0" cellpadding="5" border="0" align="center"
             style="border-color:rgb(0,0,255); border-style:groove; border-width:thin;">
        <tr>
          <td>&nbsp;</td>
          <td>
            <div align="left">
              <img src="images/cooltext467666467.png" alt="Money Manager Login"
                   height="28" width="181"/>
            </div>
          </td>
        </tr>
        <tr>
          <td>
            <div id="InvCredMessage"
                 style="visibility:hidden, font-family:Arial, Helvetica, sans-serif; font-size:small; font-style:italic; text-decoration:underline; color:Black; background-color:Orange; border-color:Blue; border-style:dotted; border-width:thin;">Invalid
                                                                                                                                                                                                                                                      Username
                                                                                                                                                                                                                                                      or
                                                                                                                                                                                                                                                      Password</div>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td char=":" nowrap="nowrap"
              style="font-family:tahoma; font-size:medium; text-align:auto;"
              valign="bottom">Username</td>
          <td>
            &nbsp;
            <input type="text" name="username" maxlength="30" size="30" tabindex="1">
            <input type="hidden" name="action" value="com.expensetracker.action.LoginAction">
          </td>
        </tr>
        <tr>
          <td style="font-family:tahoma; font-size:medium;">Password</td>
          <td>
            &nbsp;
            <input type="password" name="password" maxlength="30" size="30">
            
          </td>
        </tr>
        <tr>
          <td>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </td>
          <td>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" name="btnSubmit" value="Submit" onclick="document.expenseform.submit();">
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" name="cancel" value="Cancel" onclick="document.expenseform.cancel();">
            <!--<img alt=" " src="images/cooltext467668261.png"
                 onmouseover="this.src='images/cooltext467668261MouseOver.png';"
                 onmouseout="this.src='images/cooltext467668261.png';"
                 height="33" width="101"
                 onclick="document.expenseform.submit();"/>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <img alt=" " src="images/cooltext467669337.png"
                 onmouseover="this.src='images/cooltext467669337MouseOver.png';"
                 onmouseout="this.src='images/cooltext467669337.png';"
                 height="33" width="100"
                 onclick="document.expenseform.cancel();"/>-->
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>