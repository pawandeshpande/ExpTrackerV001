package com.expensetracker.view;

import com.expensetracker.bean.SessionEJB;

import java.util.Hashtable;

import javax.ejb.EJB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@EJB(beanInterface = SessionEJB.class,mappedName="SessionEJB",beanName = "SessionEJBBean",name = "se") 

public class SessionEJBClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();            
            SessionEJB sessionEJB = (SessionEJB)context.lookup("SessionEJBBean#com.expensetracker.bean.SessionEJB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
        return new InitialContext( env );
    }
}
