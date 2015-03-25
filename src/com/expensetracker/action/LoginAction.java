package com.expensetracker.action;

import com.expensetracker.ExpenseTrackerConstants;
import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;
import com.expensetracker.util.ServletAction;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginAction implements ServletAction {
  
  private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
  private String sView; 
  
  public LoginAction() {
  sView = null; 
  
  }


  public void setDatabase(Connection _db) {
  }

  public boolean execute(HttpServletRequest _req, HttpServletResponse _res)   throws ServletException, IOException {
   
    _res.setContentType(CONTENT_TYPE);
    HttpSession hSession = null; 
    //RequestDispatcher rd = null;
    String strSignout = _req.getParameter("signout");
    if (strSignout != null && strSignout.equals("true")) {
      hSession = _req.getSession(false);
      if (hSession != null) {
        hSession.invalidate();

      }
      //rd = _req.getRequestDispatcher("Login.jsp");
      sView = "Login.jsp";
      //rd.forward(_req, _res);
      
      return true;
    }
    try {
      
      hSession = _req.getSession(true);

      SessionEJB ejb =(SessionEJB) EMFactory.getSessionEJB();
      User usr =  ejb.VerifyUser(_req.getParameter("username"), _req.getParameter("password"));
      if (usr != null) {
        System.out.println("Name = " + usr.getName());
        System.out.println("Company = " + usr.getCompany().getName());
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_USER_ID, usr.getRowId());
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_USER, usr);
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_COMPANY, usr.getCompany());
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_COMPANY_ID, usr.getCompany().getRowId());
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_USER_NAME,usr.getName());
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_INVALID_CREDENTIALS,false);
        //rd = _req.getRequestDispatcher("/user/expenselistservlet");
        
        sView = "/user/ExpenseListAction?action=com.expensetracker.action.ExpenseListAction"; 
        //assert rd!=null; 
      } else {
        hSession.setAttribute(ExpenseTrackerConstants.SESSION_INVALID_CREDENTIALS,true);
        //rd = _req.getRequestDispatcher("Login.jsp");
        sView = "Login.jsp"; 
      }
      //rd.forward(_req, _res);
    } catch (Exception e) {
      e.printStackTrace(_res.getWriter());
    }
   
   
    return true;
  }

  public String getView() {
    
    return sView;
  }

  public Object getModel() {
    return null;
  }
}
