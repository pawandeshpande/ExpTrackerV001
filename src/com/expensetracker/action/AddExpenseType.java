package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.ExpenseType;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import java.sql.Timestamp;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddExpenseType implements ServletAction {
    private String sView;

    public AddExpenseType() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        
        HttpSession hSession = _req.getSession(false);
        ExpenseType et = new ExpenseType();
        et.setName(_req.getParameter("expensetypename"));
        et.setDescription(_req.getParameter("desc"));
           
        et.setUser((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER));
        et.setUser1((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER));
          
        et.setCompany((Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));

        et.setCreated(new Timestamp(new Date().getTime()));
        et.setActiveFlg("Y");
        
        if((_req.getParameter(ExpenseTrackerConstants.DEFAULT_FLAG))=="Y")
        et.setDefaultFlg("Y"); 
        else
        et.setDefaultFlg("N");
        et.setDeletedState("N");
        et.setUpdated(new Timestamp(new Date().getTime()));
        
        SessionEJB ejb = EMFactory.getSessionEJB(); 
        ejb.AddExpenseType(et); 
        sView = "/user/expensetypelistservlet?action=" + ExpenseTrackerConstants.CLASS_LIST_EXPENSE; 
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
