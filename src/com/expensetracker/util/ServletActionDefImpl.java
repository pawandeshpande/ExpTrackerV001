package com.expensetracker.util;

import java.sql.Connection;

public abstract class ServletActionDefImpl implements ServletAction {
    protected  String sView = null; 
    
    public ServletActionDefImpl() {
        super();
    }
    
    public String getView()
    {
        return sView;     
    }
    
    
    public Object getModel() {
        return null;
    }
    
    public void setDatabase(Connection _db) {
    }

    
}
