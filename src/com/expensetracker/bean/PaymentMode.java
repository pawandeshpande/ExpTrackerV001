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

@Entity
@NamedQueries( { @NamedQuery(name = "PaymentMode.findAll",
                             query = "select o from PaymentMode o")
        } )
@Table(name = "payment_mode", schema = "expensedb")
public class PaymentMode implements Serializable {
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Column(name = "ACTIVE_FLG")
    private String activeFlg;
    @Column(name = "CARD_NO")
    private String cardNo;
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
    @OneToMany(mappedBy = "paymentMode")
    private List<Expenses> expensesList;
    @ManyToOne
    @JoinColumn(name = "BU_ID")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private User user;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private User user1;

    public PaymentMode() {
    }

    public PaymentMode(String accountNo, String activeFlg, Company company,
                       String cardNo, Timestamp created, User user1,
                       String defaultFlg, String deletedState,
                       String description, String name, Integer rowId,
                       Timestamp updated, User user) {
        this.accountNo = accountNo;
        this.activeFlg = activeFlg;
        this.company = company;
        this.cardNo = cardNo;
        this.created = created;
        this.user1 = user1;
        this.defaultFlg = defaultFlg;
        this.deletedState = deletedState;
        this.description = description;
        this.name = name;
        this.rowId = rowId;
        this.updated = updated;
        this.user = user;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(String activeFlg) {
        this.activeFlg = activeFlg;
    }


    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
        expenses.setPaymentMode(this);
        return expenses;
    }

    public Expenses removeExpenses(Expenses expenses) {
        getExpensesList().remove(expenses);
        expenses.setPaymentMode(null);
        return expenses;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
}
