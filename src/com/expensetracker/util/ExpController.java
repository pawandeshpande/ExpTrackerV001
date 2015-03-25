package com.expensetracker.util;


import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import java.sql.*;

import javax.naming.*;

import javax.sql.*;

public class ExpController extends HttpServlet {
private String view = null; 
    public void init() {
        /* Initialize shared resources */

    }

    public void doGet(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {
        /* Forward to doPost method */
        doPost(_req, _res);
    }

    public void doPost(HttpServletRequest _req, HttpServletResponse _res) throws ServletException, IOException {

    HttpSession session = null; 
        try {
            /* Wrap request object with helper */
            RequestUtil reqUtil = new RequestUtil(_req);
            /* Create an Action object based on request parameters */
            ServletAction action = reqUtil.getAction();
            /* Pass the database connection to the action */

            /* Execute business logic */
            if (action != null && action.execute(_req, _res)) {
                /* Get appropriate view for action */
            view = action.getView();
                /* Add the model to the request attributes */
                _req.setAttribute("model", action.getModel());
                /* Forward the request to the given view */
                
            }else
            {
                view = "/NoActionClass.jsp";
            }

            session = _req.getSession(false); 
            if(session!=null && view!= null){
            RequestDispatcher dispatcher = _req.getRequestDispatcher(view);
            dispatcher.forward(_req, _res);
            }else{
            
            _res.sendRedirect("Login.jsp"); 
            
            }
       } catch (Exception e) {
            e.printStackTrace(_res.getWriter());
            }
    }

    public void destroy() {
        /* Clean up shared resources */

    }
}
