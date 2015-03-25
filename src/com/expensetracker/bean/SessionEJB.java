package com.expensetracker.bean;

import java.rmi.RemoteException;

import java.util.List;

import javax.ejb.EJBObject;
import javax.ejb.Remote;
import javax.ejb.RemoteHome;
//
//@Remote
public interface SessionEJB extends EJBObject{

  Object persistEntity(Object entity)  throws RemoteException;

  public User VerifyUser(String strUsername, String strPassword)  throws RemoteException;


// All the list methods. 
  public List<User> getUserList(Integer userId,Company comp)  throws RemoteException;
  public List<Event> getEventList(User user, Company comp)  throws RemoteException;
  public List<ExpenseType> getExpenseTypeList(User user,Company comp)  throws RemoteException;
  public List<PaymentMode> getPaymentModeList(User user,Company comp)  throws RemoteException;
  public List<Expenses> getExpensesList(User user,Company comp)  throws RemoteException;
  public List<Expenses> getExpensesList(User user,Company comp, String StartDate, String EndDate) throws RemoteException;
  
  public List<Company> getCompanyList(String Admin) throws IllegalAccessException, RemoteException;
  
  

  

  public boolean AddEvent(Event event)  throws RemoteException;

  public boolean AddExpenseType(ExpenseType expensetype)  throws RemoteException;

  public boolean AddExpenses(Expenses expenses)  throws RemoteException;

  public boolean AddCompany(Company company)  throws RemoteException;

  public boolean AddUser(User user)  throws RemoteException;

  public boolean AddPaymentMode(PaymentMode paymentmode)  throws RemoteException;
  
  public User getUser(String UserId, String CompanyId) throws RemoteException; 
  
  
  public boolean RemoveObject(Object obj) throws RemoteException; 
  
  public boolean RestoreUser(User u ) throws RemoteException; 
  
    public boolean DeleteUser(User u) throws RemoteException;
    public boolean DeleteExpense(Integer rowId)   throws RemoteException; 
    public boolean DeleteEvent(Integer rowId, boolean bRestore) throws RemoteException;
    public boolean DeletePaymentMode(Integer rowId, boolean bRestore) throws RemoteException;
    
    // Get methods for each object
    public Expenses findExpense(Integer RowId) throws RemoteException;
    public Company findCompany(Integer  RowId) throws RemoteException;
    public Event findEvent(Integer  RowId) throws RemoteException;
    
    public ExpenseType findExpenseType(Integer RowId) throws RemoteException;
    public PaymentMode findPaymentMode(Integer  RowId) throws RemoteException;
    public User findUser(Integer  RowId) throws RemoteException;
    
    // Search methods
    
    public List<Expenses> getExpensesList(User user,Company comp, String keyword) throws RemoteException;
    
    
    // Update methods for each object. 
    
    public boolean UpdateExpense(Expenses exp) throws RemoteException; 
    
    
    
}
