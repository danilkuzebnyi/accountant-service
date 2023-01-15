package com.example.accountant.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionTypeEntity type;

    @ManyToMany
    @JoinTable(name = "transaction_fee",
               joinColumns = @JoinColumn(name = "transaction_id"),
               inverseJoinColumns = @JoinColumn(name = "fee_id"))
    private Set<FeeEntity> fees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionTypeEntity getType() {
        return type;
    }

    public void setType(TransactionTypeEntity type) {
        this.type = type;
    }

    public Set<FeeEntity> getFees() {
        return fees;
    }

    public void setFees(Set<FeeEntity> fees) {
        this.fees = fees;
    }
}