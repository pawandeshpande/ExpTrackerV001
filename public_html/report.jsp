<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html> 
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <script type="text/javascript" language="javascript" src="../scripts/ts_picker.js"></script>
    <title>Report Generation</title>
</head>
  <body>
   <%@include file="/TopFrame.jsp"%>
    
  <script type='text/javascript'>
$(document).ready(function(){

    //Your Click event
    $('#btnKeywordSearch').click(function(){
    
    var SearchKeywordVal = $("#SearchKeyword").val();
    var DataString = "SearchKeyword=" + SearchKeywordVal;
    var Data = $("#SearchForm").serialize();
        $("#btnKeywordSearch").show().css("opacity",0.6);
         
         $.ajax( {
             url:'SearchAction?action=com.expensetracker.action.SearchAction',
             type:"post",
             data: Data,
             success:function(data) {
               $('#result').fadeOut("3000");
               $('#result').html("Success");
               $('#SearchResult').html(data);
        $("#btnKeywordSearch").show().css("opacity",1.0);      
               $('#result').fadeIn();
               $('#result').html("");
             }
          });
        
        
        return false;
    });

});
</script>
      
        <div id="DateSearchDiv" align="left" style="color:Black;">
  <form name="expenseform" action="reportservlet?action=com.expensetracker.action.ReportAction" method="POST">
  <div id="ReportHeadingDiv" align="left" style="background-color:Lime;">
   <table width="100%" >
        <tr>
          <td align="left">
            <h2>
              <u>Report</u>
            </h2>
          </td>
        </tr>
      </table>
     </div> 
     <div id="DateReportDiv" align="left">
       <table cellpadding="0" cellspacing="0" border="1" align="left">
      <tr>
          <td>Start Date:</td>
           <td>
            <input type="text" name="StartDate"  maxlength="30" size="10" />yyyy-mm-dd
          </td>
          
        </tr>

  <tr>
          <td>End Date:</td>
           <td>
            <input type="text" name="EndDate"  maxlength="30" size="10" />yyyy-mm-dd 
          </td>
         
        </tr>      
        
        <tr>
        <td> </td>
        <td><input type="submit" name="btnSubmit" value="Go"/></td>
        <td><input type="button" name="testlocalstorage" value="Test Local Storage" onclick="TestLocalStorage();"/></td>
        </tr>
        </table>
        </div>
        
         <div id="innerCalendar" style="position: relative; width: 200px; height: 350px;display:none" ></div>
  </form>
 
 
  </div>
   <form id="SearchForm" action="">
   
  <div id="KeywordSearchDiv" align="left" style="color:Black; background-color:Red;">
    Enter Keyword<input type="text" name="SearchKeyword" maxlength="80" size="50" />
   <button type="button" id="btnKeywordSearch" class="css3button"> Search</button>
  </div>
   
 </form>
    <div id="result">
   </div>
 
   <div id="SearchResult">
   </div>
   
  </body>
</html>

