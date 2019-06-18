package com.anz.wholesale.account.controller;

import com.anz.wholesale.account.jsonbean.AccountResponse;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import com.anz.wholesale.account.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void givenUserId_whenGetAccount_thenReturnJsonArray() throws Exception {
        Mockito.when(accountService.getAccounts("user1", PageRequest.of(0, 25))).thenReturn(getAccountResponseList());
        mockMvc.perform(get("/account/{userId}", "user1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    public void givenAccountNo_whenGetTransactions_thenReturnJsonArray() throws Exception {
        Mockito.when(accountService.getTransactions("110001", PageRequest.of(0, 25))).thenReturn(getTxnResponseList());
        mockMvc.perform(get("/account/{accountNumber}/transactions", "110001")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].transactionNumber", is("1100100")));
    }

    private List<AccountResponse> getAccountResponseList() {
        List accountList = new ArrayList<AccountResponse>();
        AccountResponse accountResponse = AccountResponse.builder().id(1L).userId("user1").accountNumber("110001").accountName("Account AU").accountType("Savings")
                .balanceDate(new Date()).currency("AUD").openingAvailableBalance(new BigDecimal("1000.45")).build();
        accountList.add(accountResponse);
        return accountList;
    }

    private List<TransactionResponse> getTxnResponseList() {
        List txnList = new ArrayList<TransactionResponse>();
        TransactionResponse transactionResponse = TransactionResponse.builder().id(1L).transactionNumber("1100100").accountNumber("110001").accountName("Account AU").debitCredit("Debit")
        .creditAmount(new BigDecimal("1000.45")).currency("AUD").debitAmount(new BigDecimal("1000.45")).build();
        txnList.add(transactionResponse);
        return txnList;
    }
}
