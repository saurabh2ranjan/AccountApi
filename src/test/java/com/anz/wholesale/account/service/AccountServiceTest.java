package com.anz.wholesale.account.service;

import com.anz.wholesale.account.domain.Account;
import com.anz.wholesale.account.domain.Transaction;
import com.anz.wholesale.account.jsonbean.AccountResponse;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import com.anz.wholesale.account.repository.AccountRepository;
import com.anz.wholesale.account.repository.TransactionRepository;
import com.anz.wholesale.account.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }
    }

    @Test
    public void whenAccountsFoundForUserId() {
        String userId = "user1";
        Pageable pageable = PageRequest.of(0, 25);
        Mockito.when(accountRepository.findAllByUserId(userId, pageable)).thenReturn(getAccountList());
        List<AccountResponse> accountList = accountService.getAccounts(userId, pageable);

        assertThat(accountList.size()).isGreaterThan(0);
    }

    @Test
    public void whenAccountsNotFoundForUserId() {
        String userId = "user1";
        Pageable pageable = PageRequest.of(0, 25);
        Mockito.when(accountRepository.findAllByUserId(userId, pageable)).thenReturn(new ArrayList<Account>());
        List<AccountResponse> accountList = accountService.getAccounts(userId, pageable);

        assertThat(accountList.size()).isEqualTo(0);
    }

    //@Test
    public void whenTxnFoundForAccountNo() {
        String accountNumber = "1100001";
        Pageable pageable = PageRequest.of(0, 25);
        Mockito.when(transactionRepository.findByAccountNumber(accountNumber, pageable)).thenReturn(getTxnList());
        List<TransactionResponse> txnList = accountService.getTransactions(accountNumber, pageable);

        assertThat(txnList.size()).isGreaterThan(0);
    }

    @Test
    public void whenTxnNotFoundForAccountNo() {
        String accountNumber = "1100001";
        Pageable pageable = PageRequest.of(0, 25);
        Mockito.when(transactionRepository.findByAccountNumber(accountNumber, pageable)).thenReturn(new ArrayList<Transaction>());
        List<TransactionResponse> txnList = accountService.getTransactions(accountNumber, pageable);

        assertThat(txnList.size()).isEqualTo(0);
    }

    private List<Account> getAccountList() {
        List<Account> accountList = new ArrayList<Account>();
        Account account = Account.builder().build();
        account.setId(1L);
        account.setAccountNumber("1100001");
        account.setAccountName("Account AU");
        accountList.add(account);
        return accountList;
    }

    private List<Transaction> getTxnList() {
        List<Transaction> txnList = new ArrayList<Transaction>();
        Transaction txn = Transaction.builder().build();
        txnList.add(txn);
        return txnList;
    }

}
