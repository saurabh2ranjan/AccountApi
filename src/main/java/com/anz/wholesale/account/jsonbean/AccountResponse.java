package com.anz.wholesale.account.jsonbean;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class AccountResponse {

    private Long id;
    private String userId;
    private String accountNumber;
    private String accountName;
    private String accountType;
    private Date balanceDate;
    private String currency;
    private BigDecimal openingAvailableBalance;
}
