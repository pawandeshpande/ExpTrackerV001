


function ValidatePassword() {
    var password = document.expenseform.password.value;
    var confirm_password = document.expenseform.confirm_password.value;
    if (password != confirm_password) {
        alert("Passwords not matching.");
        return false;
    }
    return true;
}


function AddExpense()
{
    
localStorage.setItem('ExpenseName', document.expenseform.ExpenseName.value);  
localStorage.setItem('amount', document.expenseform.amount.value);
localStorage.setItem('vat',document.expenseform.vat.value);
localStorage.setItem('totalamount', document.expenseform.totalamount.value);
localStorage.setItem('desc', document.expenseform.desc.value);
localStorage.setItem('paymentmode',document.expenseform.paymentmode.value); 
localStorage.setItem('billno',document.expenseform.billno.value);
localStorage.setItem('eventname',document.expenseform.eventname.value);

}

function TestLocalStorage()
{
    var webStorageSupported = ('localStorage' in window) && window['localStorage'] !== null;  
    if(webStorageSupported){
    localStorage.setItem('name', 'Pawan Deshpande');  
    var value = localStorage.getItem('name');  
    alert(value);  
    }
}


function SetTodaysDate(target) {
    var currentTime = new Date()
    var month = currentTime.getMonth() + 1
    var day = currentTime.getDate()
    var year = currentTime.getFullYear()
    target.value = day + "-" + month + "-" + year;

}

function DeleteExpense(rowID) {
    var deleteval = confirm("Do you want to delete this row?");
    if (deleteval)
        {
        var Target = "expenselistservlet?action=com.expensetracker.action.ExpenseListAction&do=de&id=" + rowID;
        doSubmit(Target);
        return true;
        }
    else 
        return false;
}

function DeletePaymentMode(rowID){
    var deleteval = confirm("Do you want to delete this row?");
    if (deleteval)
        {
        var Target = "PaymentModeListServlet?action=com.expensetracker.action.PaymentModeListServlet&do=de&id=" + rowID;
        doSubmit(Target);
        return true;
        }
    else 
        return false;
    
    
}

function CalculateTax() {

    var strTax = document.expenseform.tax.value;
    var strAmount = document.expenseform.amount.value;
    var strTotalamount = document.expenseform.totalamount.value;
    var tax_amt = 0.00;
    var amount = 0.00;
    var total_amount = 0.00;

    if (strAmount == "") {
        alert("Amount cannot be blank");
        return false;
    }

    if (strTax != "") {
        tax_amt = parseFloat(strTax);
    }
    amount = parseFloat(strAmount);
    total_amount = parseFloat(strTotalamount);
    total_amount = (amount + ((amount * tax_amt) / 100));

    document.expenseform.amount.value = amount + "";
    document.expenseform.totalamount.value = total_amount + "";

    return true;

}

function DoAjaxAction(Target)
{
    
}

function doSubmit(Target) {

    
    document.expenseform.action = Target;
    
    document.expenseform.submit();    
}

