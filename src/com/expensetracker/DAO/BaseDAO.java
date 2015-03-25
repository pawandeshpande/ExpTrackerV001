package com.expensetracker.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
  public BaseDAO() {
  }

  public Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/pvsr", "root",
                                      "pvsr");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

  public boolean prepareStatement(String strQuery) {
    return true;
  }
}
