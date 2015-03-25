package com.expensetracker.bean;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "company", schema = "expensedb")
@Entity
@NamedQueries( { @NamedQuery(name = "Company.findAll",
                             query = "select o from Company o")
        } )
public class Company implements Serializable {
    @Column(name = "ACTIVE_FLG")
    private String activeFlg;
    private String address;
    private Timestamp created;
    @Column(name = "CREATED_BY")
    private Integer createdBy;
    @Column(name = "DELETED_STATE")
    private String deletedState;
    private String name;
    @Column(name = "PRIMARY_CONTACT")
    private String primaryContact;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", nullable = false, insertable = false,
            updatable = true)
    private Integer rowId;
    private Timestamp updated;
    @Column(name = "UPDATED_BY")
    private Integer updatedBy;
    @OneToMany(mappedBy = "company")
    private List<ExpenseType> expenseTypeList;
    @OneToMany(mappedBy = "company")
    private List<PaymentMode> paymentModeList;
    @OneToMany(mappedBy = "company")
    private List<User> userList;
    @OneToMany(mappedBy = "company")
    private List<Expenses> expensesList;
    @OneToMany(mappedBy = "company")
    private List<Event> eventList;

    public Company() {
    }

    public Company(String activeFlg, String address, Timestamp created,
                   Integer createdBy, String deletedState, String name,
                   String primaryContact, Integer rowId, Timestamp updated,
                   Integer updatedBy) {
        this.activeFlg = activeFlg;
        this.address = address;
        this.created = created;
        this.createdBy = createdBy;
        this.deletedState = deletedState;
        this.name = name;
        this.primaryContact = primaryContact;
        this.rowId = rowId;
        this.updated = updated;
        this.updatedBy = updatedBy;
    }

    public String getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(String activeFlg) {
        this.activeFlg = activeFlg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
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

    public List<ExpenseType> getExpenseTypeList() {
        return expenseTypeList;
    }

    public void setExpenseTypeList(List<ExpenseType> expenseTypeList) {
        this.expenseTypeList = expenseTypeList;
    }

    public ExpenseType addExpenseType(ExpenseType expenseType) {
        getExpenseTypeList().add(expenseType);
        expenseType.setCompany(this);
        return expenseType;
    }

    public ExpenseType removeExpenseType(ExpenseType expenseType) {
        getExpenseTypeList().remove(expenseType);
        expenseType.setCompany(null);
        return expenseType;
    }

  
    public List<PaymentMode> getPaymentModeList() {
        return paymentModeList;
    }

    public void setPaymentModeList(List<PaymentMode> paymentModeList) {
        this.paymentModeList = paymentModeList;
    }

    public PaymentMode addPaymentMode(PaymentMode paymentMode) {
        getPaymentModeList().add(paymentMode);
        paymentMode.setCompany(this);
        return paymentMode;
    }

    public PaymentMode removePaymentMode(PaymentMode paymentMode) {
        getPaymentModeList().remove(paymentMode);
        paymentMode.setCompany(null);
        return paymentMode;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User addUser(User user) {
        getUserList().add(user);
        user.setCompany(this);
        return user;
    }

    public User removeUser(User user) {
        getUserList().remove(user);
        user.setCompany(null);
        return user;
    }

    public List<Expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }

    public Expenses addExpenses(Expenses expenses) {
        getExpensesList().add(expenses);
        expenses.setCompany(this);
        return expenses;
    }

    public Expenses removeExpenses(Expenses expenses) {
        getExpensesList().remove(expenses);
        expenses.setCompany(null);
        return expenses;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public Event addEvent(Event event) {
        getEventList().add(event);
        event.setCompany(this);
        return event;
    }

    public Event removeEvent(Event event) {
        getEventList().remove(event);
        event.setCompany(null);
        return event;
    }
}
