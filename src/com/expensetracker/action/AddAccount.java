package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.Event;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import java.sql.Timestamp;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddAccount implements ServletAction {
    private String sView;

    public AddAccount() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
       
        HttpSession hSession = _req.getSession(false);
        Event evt = new Event();
        evt.setName(_req.getParameter("eventname"));
        User u = new User();
        u.setRowId((Integer)hSession.getAttribute("USER_ID"));
        evt.setUser(u); // Created by 
        evt.setUser1(u); // updated by 
        Company comp = new Company();
        comp.setRowId((Integer)hSession.getAttribute("COMPANY_ID"));
        evt.setCompany(comp);
        evt.setCreated(new Timestamp(new Date().getTime()));
        evt.setDeletedState("N");
        evt.setDescription(evt.getName());
        evt.setActiveFlg("Y");
        SessionEJB ejb = EMFactory.getSessionEJB(); 
        ejb.AddEvent(evt);
          
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
