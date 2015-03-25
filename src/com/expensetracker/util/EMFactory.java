package com.expensetracker.util;

import com.expensetracker.bean.SessionEJB;

import com.expensetracker.bean.SessionEJBLocal;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
  private static InitialContext ic = null;
  private static SessionEJB ejb = null;

  private EMFactory() {
    ic = null;

  }

  public static SessionEJB getSessionEJB() {
    
    try {

System.out.println("\n\n\n started");
      if (ejb == null) {
        System.out.println("\n\n\n Inside");
        Hashtable env = new Hashtable(5);
           env.put(Context.INITIAL_CONTEXT_FACTORY,
                   "weblogic.jndi.WLInitialContextFactory");
           env.put(Context.PROVIDER_URL,
                   "t3://localhost:7001");
           ic = new InitialContext();//env);
        //ic = new InitialContext();
        
          SessionEJBLocal sl=(SessionEJBLocal)ic.lookup("ExpEJBs_SessionEJBLocal");
        System.out.println("\n\n\n Home : "+sl);
        ejb = sl.create();
        System.out.println("\n\n\n Remote "+ejb);
        return ejb;

      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("\n\n\n Exception"+e);
    }

    return ejb;
  }


}
