package com.expensetracker.bean;


import com.expensetracker.ExpenseTrackerConstants;

import com.expensetracker.util.ExpenseTrackerQueryConstants;

import java.lang.annotation.Annotation;

import java.rmi.RemoteException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJBHome;
import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.ejb.Stateless;

import javax.ejb.TransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "SessionEJBBean", mappedName = "moneymanager002-ExpTracker-SessionEJBBean")
@TransactionManagement 
public class SessionEJBBean implements SessionEJB {
  @PersistenceContext(name = ExpenseTrackerConstants.PERSISTENCE_UNIT_NAME)
      @Resource(name = ExpenseTrackerConstants.SESSION_EJB_NAME)
  private EntityManager em;


  public SessionEJBBean() {
       EntityManagerFactory EMF = Persistence.createEntityManagerFactory(ExpenseTrackerConstants.PERSISTENCE_UNIT_NAME);
       em = EMF.createEntityManager(); 
    em.setFlushMode(FlushModeType.COMMIT);
       
        
      
  }

  public Object mergeEntity(Object entity) {
    return em.merge(entity);
  }

  public Object persistEntity(Object entity) {
    em.persist(entity);
    return entity;
  }

  public User VerifyUser(String strUsername, String strPassword) {
    
    Query qry = em.createNamedQuery("VerifyUser"); 
    qry.setParameter("username",strUsername);
    qry.setParameter("password",strPassword);
    
    User u = null;
    try{
        u  = (User) qry.getSingleResult();
    }catch(javax.persistence.NoResultException NRException)
      {
        NRException.printStackTrace();
      }    
    return u;
  }

  public List<Event> getEventList(User user,Company comp) {
    List<Event> eventList = (List<Event>)getList(ExpenseTrackerQueryConstants.qryFindAllEvents,user,comp);
    return eventList;
  }

 
  


  public List<ExpenseType> getExpenseTypeList(User user,Company comp) {
    List<ExpenseType> expenseTypeList =(List<ExpenseType>) getList(ExpenseTrackerQueryConstants.qryFindAllExpenseTypes,user,comp);
    return expenseTypeList;
  }

  public List<User> getUserList(Integer user,Company comp) {
      
      List<User> userList = null; 
      
      try{
    Query qry = em.createQuery(ExpenseTrackerQueryConstants.qryFindAllUsers); 
    qry.setParameter("createdby",user);
    qry.setParameter("company",comp);
    userList = (List<User>)qry.getResultList(); 
      }
      catch(Exception ex)
      {
            ex.printStackTrace();  
        }
          
    return userList; 
  }

  private List getList(String strQuery, User user, Company comp)
  {
    List<Object> obj  = null;
    Query qry = em.createQuery(strQuery); 
    qry.setParameter("createdby",user);
    qry.setParameter("company",comp);
    
    obj = qry.getResultList(); 
    return obj; 
  }

  

  public List<PaymentMode> getPaymentModeList(User user,Company comp) {
  List<PaymentMode> paymentModeList = (List<PaymentMode>)getList(ExpenseTrackerQueryConstants.qryFindAllPaymentModes,user,comp);
  return paymentModeList;
  }

  public List<Expenses> getExpensesList(User user,Company comp) {
    List<Expenses> expensesList = (List<Expenses>)getList(ExpenseTrackerQueryConstants.qryFindAllExpenses,user,comp);
    return expensesList;
  }


  public List<Expenses> getExpensesList(User user,Company comp, String StartDate, String EndDate) {
  
    String query = "SELECT o FROM Expenses o where o.user=:createdby and o.company=:company and o.deletedState='N' " +
    "and o.billDate between '" + StartDate + "' and '" + EndDate + "' order by o.billDate desc";
       
    List<Expenses> expensesList = (List<Expenses>)getList(query,user,comp);
    return expensesList;
  }
  
    public List<Expenses> getExpensesList(User user,Company comp, String keyword) throws RemoteException
    {
        String query = "SELECT o FROM Expenses o where o.user=:createdby and o.company=:company and o.deletedState='N' " +
        "and o.name like '%" + keyword + "%' order by o.billDate desc";
           
        List<Expenses> expensesList = (List<Expenses>)getList(query,user,comp);
        return expensesList;
        
    }
  
  
  

  

  public List<Company> getCompanyList(String Admin) throws IllegalAccessException {

    IllegalAccessException e = null;

    if ((Admin == null) || (Admin.compareTo("Admin") != 0))
      throw e;

    String strQuery =
      "select * from Company where primary_contact='" + Admin + "'";
    Query qry = em.createNativeQuery(strQuery, Company.class);
    List<Company> companyList = (List<Company>)qry.getResultList();
    return companyList;
  }


  public boolean AddObject(Object obj) {
    try {
      
     // EntityManagerFactory EMF = Persistence.createEntityManagerFactory(ExpenseTrackerConstants.PERSISTENCE_UNIT_NAME);
      //em = EMF.createEntityManager(); 
      
      //em.getTransaction().begin();
     
      em.persist(obj);
      
      em.flush();
      //em.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    return true;

  }
  
  public boolean RemoveObject(Object obj)
  {
      try{
      
      em.remove(obj);
      em.flush();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      
          }
    
    return true;     
      
  }

public boolean RestoreUser(User u )
{
    return true;
    
    }


public boolean DeleteUser(User u){
    
    u.setDeletedState("Y");
       
    return true;    
}



  public boolean AddEvent(Event event) {
    AddObject(event);
    return true;
  }


  public boolean AddExpenseType(ExpenseType expensetype) {
      System.out.println("Inside SessionEJBBean.AddExpenseType method");
    AddObject(expensetype);
    return true;
  }

  public boolean AddExpenses(Expenses expenses) {
    AddObject(expenses);
    return true;
  }

  public boolean AddCompany(Company company) {
    AddObject(company);
    return true;
  }

  public boolean AddUser(User user) {
    System.out.println("\n\n\nInside AddUser");
    AddObject(user);
    return true;
  }

  public boolean AddPaymentMode(PaymentMode paymentmode) {
    AddObject(paymentmode);
    return true;
  }


    public void create() {
    }

    public Class value() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public EJBHome getEJBHome() {
        return null;
    }

    public Object getPrimaryKey() {
        return null;
    }

    public void remove() {
    }

    

    public Handle getHandle() {
        return null;
    }

    public boolean isIdentical(EJBObject ejbObject) {
        return false;
    }

  public User getUser(String UserId, String CompanyId) {
    
    String strQuery = "select * from User where deleted_state='N' and  bu_id=" + CompanyId +" and row_id = " + UserId;
    Query qry = em.createNativeQuery(strQuery, User.class);
    User u = (User)qry.getSingleResult(); 
    return u; 
        
  }
  
   
    public Expenses findExpense(Integer RowId)
    {
        Expenses exp = null; 
        exp = em.find(Expenses.class, RowId);
        return exp; 
        
    }
    
    public Company findCompany(Integer RowId){
        Company cmp = null; 
        cmp = em.find(Company.class, RowId); 
        return cmp; 
        }
    public Event findEvent(Integer RowId){
        Event evt = null; 
        evt = em.find (Event.class, RowId); 
        return evt; 
        
        }
   
    public ExpenseType findExpenseType(Integer RowId) {
        ExpenseType exptype = null; 
        exptype = em.find(ExpenseType.class, RowId); 
        
        return exptype; 
        
        }
    public PaymentMode findPaymentMode(Integer RowId) {
        PaymentMode paymode = null; 
        paymode = em.find(PaymentMode.class, RowId);
        return paymode; 
        
        }
    public User findUser(Integer RowId) {
        User usr = null; 
        
        usr = em.find(User.class, RowId); 
        return usr; 
        
        }
   
   public boolean UpdateExpense(Expenses exp)    
   {
       em.merge(exp); 
       return true; 
            
   }
    
    
  public boolean DeletePaymentMode(Integer rowId, boolean bRestore)
  {
      PaymentMode pm = null; 
      pm = em.find(PaymentMode.class, rowId); 
      if(pm != null){
      if(bRestore)
          pm.setDeletedState("N");
      else
          pm.setDeletedState("Y");
      em.flush();
      }else
          return false;
      
    return true;    
  }
  
  public boolean DeleteEvent(Integer rowId, boolean bRestore)
  {
      Event evt = null; 
      evt = em.find(Event.class, rowId); 
      if(evt != null){
      if(bRestore)
      evt.setDeletedState("N");
      else 
          evt.setDeletedState("Y");
      em.flush();
      }
      else 
          return false;
      
    return true;  
    }
  
  
    public boolean DeleteExpense(Integer rowId)  
    {
       
       Expenses exp  = null; 
       exp = em.find(Expenses.class, rowId); 
       exp.setDeletedState("Y");
       em.flush(); 
       
       
//       Query qry = em.createQuery(ExpenseTrackerQueryConstants.qryDeleteExpense); 
//       qry.setParameter("rowid",rowId);
//       int rows =  qry.executeUpdate(); 
//        if(rows>0)return true; 
//        else return false; 
        return true; 
        
    }
  
  
}
