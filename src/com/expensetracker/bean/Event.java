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

@Table(name = "event", schema = "expensedb")
@Entity
@NamedQueries( { @NamedQuery(name = "Event.findAll",
                             query = "select o from Event o")
        } )
public class Event implements Serializable {
    @Column(name = "ACTIVE_FLG")
    private String activeFlg;
    private Timestamp created;
    @Column(name = "DEFAULT_FLG")
    private String defaultFlg;
    @Column(name = "DELETED_STATE")
    private String deletedState;
    private String description;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID", nullable = false, insertable = false,
            updatable = true)
    private Integer rowId;
    private Timestamp updated;
    @OneToMany(mappedBy = "event")
    private List<Expenses> expensesList;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private User user;
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private User user1;
    @ManyToOne
    @JoinColumn(name = "BU_ID")
    private Company company;

    public Event() {
    }

    public Event(String activeFlg, Company company, Timestamp created,
                 User user, String defaultFlg, String deletedState,
                 String description, String name, Integer rowId,
                 Timestamp updated, User user1) {
        this.activeFlg = activeFlg;
        this.company = company;
        this.created = created;
        this.user = user;
        this.defaultFlg = defaultFlg;
        this.deletedState = deletedState;
        this.description = description;
        this.name = name;
        this.rowId = rowId;
        this.updated = updated;
        this.user1 = user1;
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


    public String getDefaultFlg() {
        return defaultFlg;
    }

    public void setDefaultFlg(String defaultFlg) {
        this.defaultFlg = defaultFlg;
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


    public List<Expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }

    public Expenses addExpenses(Expenses expenses) {
        getExpensesList().add(expenses);
        expenses.setEvent(this);
        return expenses;
    }

    public Expenses removeExpenses(Expenses expenses) {
        getExpensesList().remove(expenses);
        expenses.setEvent(null);
        return expenses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
