package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;

import com.expensetracker.bean.Company;
import com.expensetracker.bean.Event;
import com.expensetracker.bean.ExpenseType;
import com.expensetracker.bean.Expenses;
import com.expensetracker.bean.PaymentMode;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddExpense implements ServletAction {
    private String sView = null;

    public AddExpense() {
        super();
    }

    /**
     * @param _db
     */
    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
       
        HttpSession hSession = _req.getSession(false);
        Expenses expense=new Expenses();
        expense.setName(_req.getParameter("ExpenseName"));
        String strValue=_req.getParameter("amount");
        if(strValue!=null && !strValue.equals("")){
            expense.setAmount(Integer.parseInt(strValue));
        }
        
        strValue=_req.getParameter("vat");
        if(strValue!=null && !strValue.equals("")){
            expense.setTax(Integer.parseInt(strValue));
            
        }
        
        strValue=_req.getParameter("totalamount");
        if(strValue!=null && !strValue.equals("")){
            expense.setTotalAmt(Integer.parseInt(strValue));
        }
        
        expense.setDescription(_req.getParameter("desc"));
        strValue=_req.getParameter("paymentmode");
        if(strValue!=null && !strValue.equals("")){
            PaymentMode pm=new PaymentMode();
            pm.setRowId(Integer.parseInt(strValue));
            expense.setPaymentMode(pm);
        }
        expense.setBillNo(_req.getParameter("billno"));
        
        strValue=_req.getParameter("billdate");
        if(strValue!=null && !strValue.equals("")){ 
            DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date billDate = sdf.parse(strValue); 
                expense.setBillDate(billDate);
            }catch(ParseException pe)
            {
                pe.printStackTrace();
            }
                
          
        }
        
        strValue=_req.getParameter("eventname");
        if(strValue!=null && !strValue.equals("")){
            Event evt=new Event();
            evt.setRowId(Integer.parseInt(strValue));
            expense.setEvent(evt);
        }  
        
        strValue=_req.getParameter("expensetype");
        if(strValue!=null && !strValue.equals("")){
            ExpenseType exptype=new ExpenseType();
            exptype.setRowId(Integer.parseInt(strValue));
            expense.setExpenseType(exptype);
        }
        
        expense.setComments(_req.getParameter("comments"));
        
        expense.setCreated(new Timestamp(new Date().getTime()));
        expense.setDeletedState("N");      
        
        expense.setUser((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER));
        expense.setCompany((Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));
        
        SessionEJB ejb = EMFactory.getSessionEJB(); 
        ejb.AddExpenses(expense);

        sView = "/user/expenselistservlet?action=" + ExpenseTrackerConstants.CLASS_LIST_EXPENSE; 
        return true;
    }

    @Override
    public String getView() {
        return sView;
    }

    @Override
    public Object getModel() {
        return null;
    }
}
