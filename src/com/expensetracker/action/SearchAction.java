package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.Expenses;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import com.expensetracker.util.ServletActionDefImpl;

import java.io.IOException;

import java.sql.Connection;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchAction extends  ServletActionDefImpl {

    public SearchAction() {
        super();
    }

   
   
    @Override
    public boolean execute(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        RequestDispatcher rdp = null;
        
        HttpSession hSession = _req.getSession(false);
        SessionEJB ejb = EMFactory.getSessionEJB();
        Company comp =
          (Company)_req.getSession().getAttribute(ExpenseTrackerConstants.SESSION_COMPANY);
        User user =
          (User)_req.getSession().getAttribute(ExpenseTrackerConstants.SESSION_USER);
        String keyword =
          _req.getParameter(ExpenseTrackerConstants.SEARCH_KEYWORD);
        
        if ((keyword == null) || (keyword.length() == 0))
        {
            sView = "report.jsp";
            return true;
        } 
        else 
        {
          List<Expenses> lstExpenses =  ejb.getExpensesList(user, comp, keyword);
            if((lstExpenses !=null )||(lstExpenses.size()>0)){
          _req.setAttribute(ExpenseTrackerConstants.SESSION_EXPENSE_LIST,
                               lstExpenses);
            sView = "ReportOut.jsp"; 
            }
         
        }
        return true;
    }


    
}
