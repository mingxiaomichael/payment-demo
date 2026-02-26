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
import java.time.OffsetDateTime;

import com.example.payment_demo.entity.enums.PaymentMethodType;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "method_type", nullable = false, length = 30)
    private PaymentMethodType paymentMethodType;

    @Column(name = "card_number", length = 25)
    private String cardNumber;

    @Column(name = "card_holder_name", length = 120)
    private String cardHolderName;

    @Column(name = "expiry_month")
    private Integer expiryMonth;

    @Column(name = "expiry_year")
    private Integer expiryYear;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // ==========================
    // Constructors
    // ==========================

    protected PaymentMethod() {
    }

    public PaymentMethod(PaymentMethodType paymentMethodType,
                         String cardNumber,
                         String cardHolderName,
                         Integer expiryMonth,
                         Integer expiryYear,
                         OffsetDateTime createdAt,
                         Account account) {
        this.paymentMethodType = paymentMethodType;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.createdAt = createdAt;
        this.account = account;
    }

    // ==========================
    // Getters & Setters
    // ==========================

    public Long getId() {
        return id;
    }

    public PaymentMethodType getMethodType() {
        return paymentMethodType;
    }

    public void setMethodType(PaymentMethodType paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear) {
        this.expiryYear = expiryYear;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}