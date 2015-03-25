package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoadExpensePageAction implements ServletAction {
    private String sView = null; 
    public LoadExpensePageAction() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        
        RequestDispatcher rdp = null; 
        
        
          HttpSession hSession=_req.getSession(false);
          SessionEJB ejb = EMFactory.getSessionEJB();
          
        //List lBorrower=ejb.getBorrowerList((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER),(Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));
        List lExpenseType=ejb.getExpenseTypeList((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER),(Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));
        List lEventList=ejb.getEventList((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER),(Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));
        List lPaymentMode=ejb.getPaymentModeList((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER),(Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));
        
        if(lExpenseType!=null){
          _req.setAttribute(ExpenseTrackerConstants.SESSION_EXPENSETYPE_LIST,lExpenseType);
        }
        //request.setAttribute(ExpenseTrackerConstants.SESSION_BORROWER_LIST,lBorrower);
        if(lEventList!=null){
        _req.setAttribute(ExpenseTrackerConstants.SESSION_EVENT_LIST,lEventList);
        }
        if(lPaymentMode!=null){
        _req.setAttribute(ExpenseTrackerConstants.SESSION_PAYMENTMODE_LIST,lPaymentMode);
        }
        _req.setAttribute(ExpenseTrackerConstants.SESSION_INVALID_CREDENTIALS,"false");
        
        String Action= _req.getParameter(ExpenseTrackerConstants.SERVLET_MODE_PARAM);
        if(Action!=null && Action.equals(ExpenseTrackerConstants.EDIT_MODE)){
          sView = ExpenseTrackerConstants.VIEW_EDIT_EXPENSE;
          return true;
        }
        else
        if(Action!=null && Action.equals(ExpenseTrackerConstants.ADD_MODE)){       
          sView = ExpenseTrackerConstants.VIEW_ADD_EXPENSE;
          return true;
          }
        
        
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
