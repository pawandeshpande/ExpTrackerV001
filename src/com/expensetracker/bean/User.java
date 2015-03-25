package com.expensetracker.bean;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "user", schema = "expensedb")
@Entity
@NamedQueries( { @NamedQuery(name = "VerifyUser",
                             query = "SELECT U FROM User U  WHERE U.password = :password  AND U.username = :username")
        , @NamedQuery(name = "User.findAll", query = "select o from User o")
        } )
public class User implements Serializable {
    @Column(name = "ACTIVE_FLG")
    private String activeFlg;
    private Timestamp created;
    @Column(name = "CREATED_BY")
    private Integer createdBy;
    @Column(name = "DELETED_STATE")
    private String deletedState;
    private String name;
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", nullable = false, insertable = false,
            updatable = true)
    private Integer rowId;
    private Timestamp updated;
    @Column(name = "UPDATED_BY")
    private Integer updatedBy;
    private String username;
    @OneToMany(mappedBy = "user")
    private List<ExpenseType> expenseTypeList;
    @OneToMany(mappedBy = "user")
    private List<Expenses> expensesList;
    @OneToMany(mappedBy = "user1")
    private List<ExpenseType> expenseTypeList1;
    @OneToMany(mappedBy = "user")
    private List<Event> eventList;
    @OneToMany(mappedBy = "user1")
    private List<Expenses> expensesList1;
    @ManyToOne
    @JoinColumn(name = "BU_ID")
    private Company company;
    @OneToMany(mappedBy = "user")
    private List<PaymentMode> paymentModeList;
    @OneToMany(mappedBy = "user1")
    private List<PaymentMode> paymentModeList1;
    @OneToMany(mappedBy = "user1")
    private List<Event> eventList1;

    public User() {
    }

    public User(String activeFlg, Company company, Timestamp created,
                Integer createdBy, String deletedState, String name,
                String password, Integer rowId, Timestamp updated,
                Integer updatedBy, String username) {
        this.activeFlg = activeFlg;
        this.company = company;
        this.created = created;
        this.createdBy = createdBy;
        this.deletedState = deletedState;
        this.name = name;
        this.password = password;
        this.rowId = rowId;
        this.updated = updated;
        this.updatedBy = updatedBy;
        this.username = username;
    }

    public String getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(String activeFlg) {
        this.activeFlg = activeFlg;
    }


    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getDeletedState() {
        return deletedState;
    }

    public void setDeletedState(String deletedState) {
        this.deletedState = deletedState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ExpenseType> getExpenseTypeList() {
        return expenseTypeList;
    }

    public void setExpenseTypeList(List<ExpenseType> expenseTypeList) {
        this.expenseTypeList = expenseTypeList;
    }

    public ExpenseType addExpenseType(ExpenseType expenseType) {
        getExpenseTypeList().add(expenseType);
        expenseType.setUser(this);
        return expenseType;
    }

    public ExpenseType removeExpenseType(ExpenseType expenseType) {
        getExpenseTypeList().remove(expenseType);
        expenseType.setUser(null);
        return expenseType;
    }

    public List<Expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }

    public Expenses addExpenses(Expenses expenses) {
        getExpensesList().add(expenses);
        expenses.setUser(this);
        return expenses;
    }

    public Expenses removeExpenses(Expenses expenses) {
        getExpensesList().remove(expenses);
        expenses.setUser(null);
        return expenses;
    }

    public List<ExpenseType> getExpenseTypeList1() {
        return expenseTypeList1;
    }

    public void setExpenseTypeList1(List<ExpenseType> expenseTypeList1) {
        this.expenseTypeList1 = expenseTypeList1;
    }

    public ExpenseType addExpenseType1(ExpenseType expenseType) {
        getExpenseTypeList1().add(expenseType);
        expenseType.setUser1(this);
        return expenseType;
    }

    public ExpenseType removeExpenseType1(ExpenseType expenseType) {
        getExpenseTypeList1().remove(expenseType);
        expenseType.setUser1(null);
        return expenseType;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public Event addEvent(Event event) {
        getEventList().add(event);
        event.setUser(this);
        return event;
    }

    public Event removeEvent(Event event) {
        getEventList().remove(event);
        event.setUser(null);
        return event;
    }

  
    public List<Expenses> getExpensesList1() {
        return expensesList1;
    }

    public void setExpensesList1(List<Expenses> expensesList1) {
        this.expensesList1 = expensesList1;
    }

    public Expenses addExpenses1(Expenses expenses) {
        getExpensesList1().add(expenses);
        expenses.setUser1(this);
        return expenses;
    }

    public Expenses removeExpenses1(Expenses expenses) {
        getExpensesList1().remove(expenses);
        expenses.setUser1(null);
        return expenses;
    }

   

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<PaymentMode> getPaymentModeList() {
        return paymentModeList;
    }

    public void setPaymentModeList(List<PaymentMode> paymentModeList) {
        this.paymentModeList = paymentModeList;
    }

    public PaymentMode addPaymentMode(PaymentMode paymentMode) {
        getPaymentModeList().add(paymentMode);
        paymentMode.setUser(this);
        return paymentMode;
    }

    public PaymentMode removePaymentMode(PaymentMode paymentMode) {
        getPaymentModeList().remove(paymentMode);
        paymentMode.setUser(null);
        return paymentMode;
    }

    public List<PaymentMode> getPaymentModeList1() {
        return paymentModeList1;
    }

    public void setPaymentModeList1(List<PaymentMode> paymentModeList1) {
        this.paymentModeList1 = paymentModeList1;
    }

    public PaymentMode addPaymentMode1(PaymentMode paymentMode) {
        getPaymentModeList1().add(paymentMode);
        paymentMode.setUser1(this);
        return paymentMode;
    }

    public PaymentMode removePaymentMode1(PaymentMode paymentMode) {
        getPaymentModeList1().remove(paymentMode);
        paymentMode.setUser1(null);
        return paymentMode;
    }

    public List<Event> getEventList1() {
        return eventList1;
    }

    public void setEventList1(List<Event> eventList1) {
        this.eventList1 = eventList1;
    }

    public Event addEvent1(Event event) {
        getEventList1().add(event);
        event.setUser1(this);
        return event;
    }

    public Event removeEvent1(Event event) {
        getEventList1().remove(event);
        event.setUser1(null);
        return event;
    }
}
