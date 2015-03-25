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

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserListAction implements ServletAction{
  private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

private String sView ; 


public UserListAction()
{ sView = null; 
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
  
    Company comp =(Company)  request.getSession().getAttribute(ExpenseTrackerConstants.SESSION_COMPANY);
    System.out.println("\n\nUser id = "+ request.getSession().getAttribute(ExpenseTrackerConstants.SESSION_USER_ID) );
    Integer userId = (Integer)request.getSession().getAttribute(ExpenseTrackerConstants.SESSION_USER_ID);
    SessionEJB ejb = EMFactory.getSessionEJB();
    List<User> lstUsers = ejb.getUserList(userId,comp);
    request.setAttribute(ExpenseTrackerConstants.SESSION_USER_LIST, lstUsers);
    
    sView = "UsersList.jsp";
    //RequestDispatcher rdp = request.getRequestDispatcher("UsersList.jsp");
    //rdp.forward(request, response);
    
    return true;
  }
}
