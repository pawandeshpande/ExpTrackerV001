package com.expensetracker;

import com.expensetracker.bean.SessionEJB;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SessionEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            SessionEJB sessionEJB = (SessionEJB)context.lookup("ExpenseTrackerConstants.SESSION_EJB_NAME#com.expensetracker.bean.SessionEJB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.JBossRemotingContextFactory" );
        env.put(Context.PROVIDER_URL, "http://localhost:8080/invoker/JNDIFactory");
        return new InitialContext( env );
    }
}
