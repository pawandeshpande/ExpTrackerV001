package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUser implements ServletAction {
    public AddUser() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        
        HttpSession hSession = _req.getSession(false);
        
        User us = new User();
        us.setName(_req.getParameter("name"));
        us.setUsername(_req.getParameter("username"));
        String password = _req.getParameter("password");
        us.setPassword(password);
        
        Company c =(Company) hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY);
        us.setCompany(c);
        us.setCreatedBy((Integer)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER_ID));
        us.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
        us.setUpdated(new Timestamp(new java.util.Date().getTime()));
        us.setUpdatedBy((Integer)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER_ID));
        us.setActiveFlg("Y");
        us.setDeletedState("N");
        SessionEJB ejb = EMFactory.getSessionEJB(); 
        if(ejb.AddUser(us))
            return true;
        return false;
    }

    @Override
    public String getView() {
        return null;
    }

    @Override
    public Object getModel() {
        return null;
    }
}
