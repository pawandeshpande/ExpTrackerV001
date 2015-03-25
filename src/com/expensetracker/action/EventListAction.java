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

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventListAction implements ServletAction {
    private String sView;
    public EventListAction() {
        super();
    }

    @Override
    public void setDatabase(Connection _db) {
    }

    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        
        String Action= _req.getParameter(ExpenseTrackerConstants.SERVLET_MODE_PARAM);
        if(Action!=null && Action.equals(ExpenseTrackerConstants.EDIT_MODE)){
          sView = ExpenseTrackerConstants.VIEW_EDIT_ACCOUNT;
          return true;
        }
        else
        if(Action!=null && Action.equals(ExpenseTrackerConstants.ADD_MODE)){       
          sView = ExpenseTrackerConstants.VIEW_ADD_ACCOUNT;
          return true;
          }
        
        
        Company comp =
          (Company)_req.getSession().getAttribute(ExpenseTrackerConstants.SESSION_COMPANY);
        User user =
            (User)_req.getSession().getAttribute(ExpenseTrackerConstants.SESSION_USER);


        

        SessionEJB ejb = EMFactory.getSessionEJB();
        List<Event> lstEvents = ejb.getEventList(user,comp);
        _req.setAttribute(ExpenseTrackerConstants.SESSION_EVENT_LIST,
                             lstEvents);
        sView = "EventsList.jsp";
        //RequestDispatcher rdp = _req.getRequestDispatcher("EventsList.jsp");
        //rdp.forward(_req, _res);
       
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
