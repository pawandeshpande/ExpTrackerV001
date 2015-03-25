package com.expensetracker.test;

import com.expensetracker.bean.SessionEJB;
import com.expensetracker.bean.SessionEJBBean;

import com.expensetracker.bean.User;
import com.expensetracker.util.EMFactory;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SessionEJBBeanTest {
    public SessionEJBBeanTest() {
    }

    public static void main(String[] args) {
        String[] args2 = { SessionEJBBeanTest.class.getName() };
        org.junit.runner.JUnitCore.main(args2);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(SessionEJBBeanTest.class);
    }

    /**
     * @see com.expensetracker.bean.SessionEJBBean#VerifyUser(String,String)
     */
    @Test
    public void testVerifyUser() throws RemoteException {
        
        String Username = "Admin";
        String Password = "Admin"; 
       
        try {
                SessionEJB ejb = (SessionEJB)EMFactory.getSessionEJB();
                User usr = ejb.VerifyUser(Username, Password);
                assertTrue("Username is Admin - passed ", ("Admin" == usr.getUsername()));
                assertTrue("Company = Default - passed", (  "Default" == usr.getCompany().getName()));
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     
}
