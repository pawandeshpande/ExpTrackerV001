package com.expensetracker.util;



import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import oracle.security.audit.util.Base64;


public class RequestUtil {
    private Base64 base64codec;
    HttpServletRequest request;

    public RequestUtil(HttpServletRequest _req) throws ServletException,
                                                       IOException {
        request = _req;
    }

    public ServletAction getAction() {
        /* Use factory to create action based on request parms */
        String action = (String)request.getParameter("action");
    
      // byte[] decodedAction = base64codec.decode(action) ;
        //   String ActionClass = decodedAction.toString(); 
        String ActionClass = action; 
        if(ActionClass!=null)
        return ServletActionFactory.createAction(ActionClass);
        else
        return null;
    }
}
