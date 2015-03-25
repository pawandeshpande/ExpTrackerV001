package com.expensetracker.bean;

import java.io.Serializable;

import java.util.Date;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries( { @NamedQuery(name = "Expenses.findAll",
                             query = "select o from Expenses o")
        } )
@Table(name = "expenses", schema = "expensedb")
public class Expenses implements Serializable {
    private Number amount;
    @Temporal(TemporalType.DATE)
    @Column(name = "BILL_DATE")
    private Date billDate;
    @Column(name = "BILL_NO")
    private String billNo;
    private String comments;
    private Timestamp created;
    @Column(name = "DELETED_STATE")
    private String deletedState;
    private String description;
    private String name;
    private Number quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", nullable = false, insertable = false,
            updatable = true)
    private Integer rowId;
    @Column(name = "SERIAL_NO")
    private String serialNo;
    private Number tax;
    @Column(name = "TOTAL_AMT")
    private Number totalAmt;
    @Column(name = "UNIT_PRICE")
    private Number unitPrice;
    private Timestamp updated;
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private User user;
    @ManyToOne
    @JoinColumn(name = "EXPENSE_TYPE_ID")
    private ExpenseType expenseType;
    @ManyToOne
    @JoinColumn(name = "PAYMENT_MODE_ID")
    private PaymentMode paymentMode;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private User user1;
    @ManyToOne
    @JoinColumn(name = "BU_ID")
    private Company company;

    public Expenses() {
    }

    public Expenses(Number amount, Date billDate, String billNo,
                    Company company, String comments,
                    Timestamp created, User user1, String deletedState,
                    String description, Event event, ExpenseType expenseType,
                    String name, PaymentMode paymentMode, Number quantity,
                    Integer rowId, String serialNo, Number tax,
                    Number totalAmt, Number unitPrice, Timestamp updated,
                    User user) {
        this.amount = amount;
        this.billDate = billDate;
        this.billNo = billNo;
        
        this.company = company;
        this.comments = comments;
        this.created = created;
        this.user1 = user1;
        this.deletedState = deletedState;
        this.description = description;
        this.event = event;
        this.expenseType = expenseType;
        this.name = name;
        this.paymentMode = paymentMode;
        this.quantity = quantity;
        this.rowId = rowId;
        this.serialNo = serialNo;
        this.tax = tax;
        this.totalAmt = totalAmt;
        this.unitPrice = unitPrice;
        this.updated = updated;
        this.user = user;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }


    public String getDeletedState() {
        return deletedState;
    }

    public void setDeletedState(String deletedState) {
        this.deletedState = deletedState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Number getTax() {
        return tax;
    }

    public void setTax(Number tax) {
        this.tax = tax;
    }

    public Number getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Number totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Number getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Number unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    
}
