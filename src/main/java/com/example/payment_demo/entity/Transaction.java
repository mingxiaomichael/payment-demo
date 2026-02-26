package com.example.payment_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.example.payment_demo.entity.enums.PaymentMethodType;

/*

*/
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id", nullable = false)
    private Account toAccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method_type", nullable = false, length = 30)
    private PaymentMethodType paymentMethodType;

    @Column(name = "payment_card_number", nullable = false, length = 25)
    private String paymentCardNumber;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    protected Transaction() {
    }

    public Transaction(Account fromAccount,
                       Account toAccount,
                       PaymentMethodType paymentMethodType,
                       String paymentCardNumber,
                       BigDecimal amount,
                       OffsetDateTime createdAt) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.paymentMethodType = paymentMethodType;
        this.paymentCardNumber = paymentCardNumber;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    // ==========================
    // Getters
    // ==========================

    public Long getId() {
        return id;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public PaymentMethodType getPaymentMethodType() {
        return paymentMethodType;
    }

    public String getPaymentCardNumber() {
        return paymentCardNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    // ==========================
    // Optional Setters (Use Carefully)
    // ==========================

    // Usually we DO NOT expose these in financial systems,
    // but adding minimal setters for flexibility in demo.

    public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public void setPaymentCardNumber(String paymentCardNumber) {
        this.paymentCardNumber = paymentCardNumber;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
