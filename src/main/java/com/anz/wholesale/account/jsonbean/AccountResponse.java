package com.anz.wholesale.account.jsonbean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@ApiModel(description = "Account Enquiry Response")
public class AccountResponse {

    @ApiModelProperty(value = "Account number", example = "1100001")
    private String accountNumber;
    @ApiModelProperty(value = "Account Name", example = "Account AU")
    private String accountName;
    @ApiModelProperty(value = "Account Type", example = "Savings")
    private String accountType;
    @ApiModelProperty(value = "Account Balance Date", example = "2019-05-30")
    private Date balanceDate;
    @ApiModelProperty(value = "Account Currency", example = "AUD")
    private String currency;
    @ApiModelProperty(value = "Available opening balance", example = "1000")
    private BigDecimal openingAvailableBalance;
}
