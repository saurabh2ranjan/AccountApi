package com.anz.wholesale.account.jsonbean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class TransactionResponse {

    private Long id;
    private Long accountId;
    private String accountNumber;
    private String accountName;
    private Date valueDate;
    private String currency;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private String debitCredit;
    private String transactionNumber;
}
