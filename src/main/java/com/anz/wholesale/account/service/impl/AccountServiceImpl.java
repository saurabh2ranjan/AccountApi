package com.anz.wholesale.account.service.impl;

import com.anz.wholesale.account.jsonbean.AccountResponse;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import com.anz.wholesale.account.mapper.AccountMapper;
import com.anz.wholesale.account.mapper.TransactionMapper;
import com.anz.wholesale.account.repository.AccountRepository;
import com.anz.wholesale.account.repository.TransactionRepository;
import com.anz.wholesale.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<AccountResponse> getAccounts(String userId, Pageable page) {
        return AccountMapper.toAccountResponse(accountRepository.findAllByUserId(userId, page));
    }

    @Override
    public List<TransactionResponse> getTransactions(String accountNumber, Pageable page) {
        return TransactionMapper.toTransactionResponse(transactionRepository.findByAccountNumber(accountNumber, page));
    }
}
