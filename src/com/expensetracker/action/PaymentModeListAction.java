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

import java.sql.RowId;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentModeListAction implements ServletAction {
    private String sView = null; 
    
    public PaymentModeListAction() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        
        boolean result = false;
        SessionEJB ejb = EMFactory.getSessionEJB();
        String Action= _req.getParameter(ExpenseTrackerConstants.SERVLET_MODE_PARAM);
        String RowId = (String)_req.getParameter(ExpenseTrackerConstants.SERVLET_ID_PARAM);
        
        
        if(Action!=null && Action.equals(ExpenseTrackerConstants.EDIT_MODE)){
          sView = ExpenseTrackerConstants.VIEW_EDIT_PAYMENTMODE;
          return true;
        }
        else
        if(Action!=null && Action.equals(ExpenseTrackerConstants.ADD_MODE)){       
          sView = ExpenseTrackerConstants.VIEW_ADD_PAYMENTMODE;
          return true;
          }
        else 
        if(Action != null && Action.equals(ExpenseTrackerConstants.DELETE_MODE)){
                result = ejb.DeletePaymentMode(Integer.valueOf(RowId), false);
                if(result)
                {
                sView = "PaymentModeListAction?action=" + ExpenseTrackerConstants.CLASS_LIST_PAYMENTMODES;
                // We are using sendRedirect here because, forwarding the request will keep the 
                // do=delete parameter and it will again call the delete loop. 
                _res.sendRedirect(sView);
                }else
                    return false;
                
            }
        

        Company comp =
          (Company)_req.getSession().getAttribute(ExpenseTrackerConstants.SESSION_COMPANY);
        User user =
            (User)_req.getSession().getAttribute(ExpenseTrackerConstants.SESSION_USER);

        
        List<PaymentMode> lstPaymentMode = ejb.getPaymentModeList(user,comp);
        _req.setAttribute(ExpenseTrackerConstants.SESSION_PAYMENTMODE_LIST,
                             lstPaymentMode);
        
        sView = "/PaymentModeList.jsp"; 
        
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
