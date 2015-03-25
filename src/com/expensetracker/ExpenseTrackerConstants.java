package com.expensetracker;

public class ExpenseTrackerConstants {
  public static final String DEFAULT_COMPANY = "1";
  public static final String DEFAULT_USER = "1";
  public static final String PERSISTANCE_UNIT = "ExpenseTracker";
  public static final String SESSION_COMPANY = "COMPANY_OBJECT";
  public static final String SESSION_COMPANY_ID = "COMPANY_ID";
  public static final String SESSION_USER = "USER_OBJECT";
  public static final String SESSION_USER_ID = "USER_ID";
  public static final String SESSION_USER_NAME = "USER_NAME";
  public static final String SESSION_USER_LIST = "USER_LIST";
  public static final String SESSION_PAYMENTMODE_LIST = "PAYMENTMODE_LIST";
  public static final String SESSION_BORROWER_LIST = "BORROWER_LIST";
  public static final String SESSION_EXPENSE_LIST = "EXPENSE_LIST";
  public static final String SESSION_COMPANY_LIST = "COMPANY_LIST";
  public static final String SESSION_EVENT_LIST = "EVENT_LIST";
  public static final String SESSION_EXPENSETYPE_LIST = "EXPENSETYPE_LIST";
  public static final String SESSION_INVALID_CREDENTIALS="INVALID_CREDENTIALS";
  public static final String SESSION_SIGNOUT="SIGNOUT";
  public static final String PERSISTENCE_UNIT_NAME="ExpenseTracker";
  public static final String SESSION_EJB_NAME ="SessionEJB";
  public static final String DEFAULT_FLAG ="DefaultFlag";
  public static final String EDIT_MODE="EDIT"; 
  public static final String DELETE_MODE="de";
  public static final String LIST_MODE="LIST";
  public static final String SERVLET_ID_PARAM="id";
  public static final String SERVLET_MODE_PARAM="do";
  public static final String ADD_MODE = "ADD";
  public static final String REPORT_START_DATE="StartDate";
  public static final String REPORT_END_DATE="EndDate";
  public static final String SEARCH_KEYWORD ="SearchKeyword";
  public static final String SESSION_EDIT_EXPENSE = "EditExpense";
  public static final String VIEW_EDIT_EXPENSE = "editexpense.jsp";
    public static final String VIEW_ADD_EXPENSE = "Expense.jsp";
    public static final String VIEW_ADD_PAYMENTMODE = "paymentmode.jsp";
    public static final String VIEW_EDIT_PAYMENTMODE = "editpaymentmode.jsp";
    public static final String VIEW_EDIT_ACCOUNT = "editaccount.jsp";
    public static final String VIEW_ADD_ACCOUNT = "AddAccount.jsp";
    public static final String VIEW_ADD_EXPENSETYPE = "AddExpensesType.jsp";
    public static final String VIEW_EDIT_EXPENSETYPE = "EditExpenseType.jsp";
    //ACTIONS
    public static final String CLASS_LIST_EXPENSETYPES = "com.expensetracker.action.ExpenseTypeListAction";
    
    public static final String CLASS_ADD_EXPENSE = "com.expensetracker.action.AddExpense";
    public static final String CLASS_LIST_EXPENSE = "com.expensetracker.action.ExpenseListAction";
    public static final String CLASS_EXPENSE_REPORT = "com.expensetracker.action.ReportAction";
    public static final String CLASS_ADD_ACCOUNT = "com.expensetracker.action.AddAccount";
    public static final String CLASS_LIST_PAYMENTMODES = "com.expensetracker.action.PaymentModeListAction";
    public static final String CLASS_SEARCH_ACTION="com.expensetracker.action.SearchAction";
    public static final String CLASS_USER_LIST  = "com.expensetracker.action.UserListAction";

}
