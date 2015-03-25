package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.Company;
import com.expensetracker.bean.ExpenseType;
import com.expensetracker.bean.Expenses;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.servlet.LoadExpensesPageServlet;
import com.expensetracker.util.EMFactory;

import com.expensetracker.util.ServletAction;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;

import java.text.DateFormat;

import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class ExpenseListAction implements ServletAction {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private String sView;

    public ExpenseListAction() {
        sView = null;
    }


    public void setDatabase(Connection _db) {
    }

    public String getView() {

        return sView;
    }

    public Object getModel() {
        return null;
    }


    public boolean execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean result = false;
        RequestDispatcher rdp = null;
        Company comp = (Company)request.getSession().getAttribute(ExpenseTrackerConstants.SESSION_COMPANY);
        User user = (User)request.getSession().getAttribute(ExpenseTrackerConstants.SESSION_USER);

        String action = (String)request.getParameter("do");

        SessionEJB ejb = EMFactory.getSessionEJB();

        String RowId = (String)request.getParameter("id");

        if (action != null && action.equals("delete")) {
            result = ejb.DeleteExpense(Integer.valueOf(RowId));
            sView = "expenselistservlet?action=" + ExpenseTrackerConstants.CLASS_LIST_EXPENSE;
            // We are using sendRedirect here because, forwarding the request will keep the 
            // do=delete parameter and it will again call the delete loop. 
            response.sendRedirect(sView);
           //return true;
        } else if (action != null && action.equals("edit")) {

            Expenses exp = ejb.findExpense(Integer.valueOf(RowId));
            //  result = ejb.UpdateExpense(exp);
            request.setAttribute(ExpenseTrackerConstants.SESSION_EDIT_EXPENSE, exp);

            sView = "/user/LoadExpensesPageServlet?action=com.expensetracker.action.LoadExpensesPageServlet&do=EDIT";
            return true;
            }


        List<Expenses> lstExpense = ejb.getExpensesList(user, comp);
        request.setAttribute(ExpenseTrackerConstants.SESSION_EXPENSE_LIST, lstExpense);
        sView = "ExpenseList.jsp";
        
        //rdp = request.getRequestDispatcher("/ExpenseList.jsp");
        //assert rdp!=null;
        //rdp.forward(request, response);
        return true;
    }


}
