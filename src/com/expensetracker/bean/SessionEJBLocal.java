package com.expensetracker.bean;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.Local;


@Local
public interface SessionEJBLocal extends EJBHome{
    public SessionEJB create() throws RemoteException, CreateException;
  /*Object mergeEntity(Object entity) throws RemoteException;

  Object persistEntity(Object entity) throws RemoteException;

  public User VerifyUser(String strUsername, String strPassword) throws RemoteException;

  public List<Event> getEventList(String CompanyId) throws RemoteException;

  public List<ExpenseType> getExpenseTypeList(String CompanyId) throws RemoteException;

  public List<User> getUserList(String CompanyId) throws RemoteException;

  public List<PaymentMode> getPaymentModeList(String CompanyId) throws RemoteException;

  public List<Expenses> getExpensesList(String CompanyId) throws RemoteException;

  public List<Borrower> getBorrowerList(String CompanyId) throws RemoteException;

  public List<Company> getCompanyList(String Admin) throws IllegalAccessException, RemoteException;


  public boolean AddBorrower(Borrower borrower) throws RemoteException;

  public boolean AddEvent(Event event) throws RemoteException;

  public boolean AddExpenseType(ExpenseType expensetype) throws RemoteException;

  public boolean AddExpenses(Expenses expenses) throws RemoteException;

  public boolean AddCompany(Company company) throws RemoteException;

  public boolean AddUser(User user) throws RemoteException;

  public boolean AddPaymentMode(PaymentMode paymentmode) throws RemoteException;

  public User getUser(String UserId, String CompanyId) throws RemoteException; 
*/

}
