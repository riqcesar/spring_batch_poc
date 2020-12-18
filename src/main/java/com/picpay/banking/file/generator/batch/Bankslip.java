package com.picpay.banking.file.generator.batch;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@Entity
@Table(name = "BANKSLIP")
public class Bankslip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String barcode;

    private LocalDate expiredDate;

    private BigDecimal amount;

    private int institutionCode;

    private Status status;

    public Bankslip() {
    }

    public Bankslip(final String barcode, final LocalDate expiredDate, final BigDecimal amount, final int institutionCode, final Status status) {
        this.barcode = barcode;
        this.expiredDate = expiredDate;
        this.amount = amount;
        this.institutionCode = institutionCode;
        this.status = status;
    }

    public Bankslip addJuros(final int i) {
        this.amount = this.amount.add(new BigDecimal(i));
        return this;
    }

}
