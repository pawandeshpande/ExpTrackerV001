package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.PaymentMode;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPaymentMode implements ServletAction {
    
    private String sView; 
    
    public AddPaymentMode() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
       
        HttpSession hSession = _req.getSession(false);
        PaymentMode pm = new PaymentMode();
        pm.setName(_req.getParameter("name"));
        pm.setCardNo(_req.getParameter("creditcardno"));
        pm.setAccountNo(_req.getParameter("accountno"));
        pm.setCompany((Company)hSession.getAttribute(ExpenseTrackerConstants.SESSION_COMPANY));
        // Set created by 
        pm.setUser((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER));
        // Set updated by 
        pm.setUser1((User)hSession.getAttribute(ExpenseTrackerConstants.SESSION_USER));
        pm.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
        pm.setUpdated(new java.sql.Timestamp(new java.util.Date().getTime()));
        String DefaultFlag = _req.getParameter(ExpenseTrackerConstants.DEFAULT_FLAG);
        pm.setDefaultFlg(DefaultFlag);
        pm.setDeletedState("N");  
        pm.setActiveFlg("Y");
        
        SessionEJB ejb = EMFactory.getSessionEJB(); 
        ejb.AddPaymentMode(pm); 
        sView = "/user/paymentmodelistservlet?action=" + ExpenseTrackerConstants.CLASS_LIST_PAYMENTMODES;
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
