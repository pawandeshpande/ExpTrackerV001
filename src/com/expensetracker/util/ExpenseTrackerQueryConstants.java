package com.expensetracker.util;

public class ExpenseTrackerQueryConstants {
  public static final String INSERT_USER =
    "insert into user(row_id,name,username,password,bu_id,created) values(?,?,?,?,?,?)";
  
  public static final String qryVerifyUser="SELECT U FROM User U  WHERE U.password = :password  AND U.username = :username";
  public static final String qryFindAllUsers="SELECT o FROM User o where o.createdBy=:createdby and o.company=:company and o.deletedState='N' order by o.name"; 
  public static final String qryFindAllExpenses="SELECT o FROM Expenses o where o.user=:createdby and o.company=:company and o.deletedState='N' order by o.billDate  desc"; 
  public static final String qryFindAllPaymentModes="SELECT o FROM PaymentMode o where o.user=:createdby and o.company=:company and o.deletedState='N'"; 
  public static final String qryFindAllBorrowers="SELECT o FROM Borrower o where o.user=:createdby and o.company=:company and o.deletedState='N'"; 
  public static final String qryFindAllExpenseTypes="SELECT o FROM ExpenseType o where o.user=:createdby and o.company=:company  and o.deletedState='N' order by o.name"; 
  public static final String qryFindAllEvents="SELECT o FROM Event o where o.user=:createdby and o.company=:company  and o.deletedState='N' order by o.name"; 
  public static final String qryFindAllCompanies="SELECT o FROM Company o where o.user=:createdby and o.company=:company  and o.deletedState='N'"; 
  public static final String qryInitCompany="SELECT o FROM Company o JOIN FETCH Borrower where o.createdBy=:sessionuser"; 
  
 // Get single object queries 
  
  public static final String qryGetExpense="SELECT o from Expenses o where o.rowId=:rowid";
  
  public static final String qryDeleteExpense="UPDATE Expenses o SET o.deletedState='Y' where o.rowId=:rowid";
  
}
 