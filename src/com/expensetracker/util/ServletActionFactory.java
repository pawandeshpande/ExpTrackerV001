package com.expensetracker.util;

import com.expensetracker.action.LoginAction;

import java.util.logging.Logger;


abstract class ServletActionFactory {
/**
* Instantiate and return the appropriate
* Action object
*/
public static ServletAction createAction(String _actionClass)
{
Class actionObj = null;
ServletAction action = null;
try {
actionObj = Class.forName(_actionClass);
action = (ServletAction) actionObj.newInstance();
}
catch (Exception e) {
            e.printStackTrace();
            
        }
return action;
}


}
