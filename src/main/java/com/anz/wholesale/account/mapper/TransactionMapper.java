package com.anz.wholesale.account.mapper;

import com.anz.wholesale.account.domain.Transaction;
import com.anz.wholesale.account.jsonbean.TransactionResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionMapper {

    public static List<TransactionResponse> toTransactionResponse(List<Transaction> transactions) {

        return Optional.ofNullable(transactions).orElseGet(ArrayList::new)
                .stream()
                .map(TransactionMapper::toTransactionResponse)
                .collect(Collectors.toList());
    }

    public static TransactionResponse toTransactionResponse(Transaction transaction) {
        TransactionResponse transactionResponse = TransactionResponse.builder().build();
        BeanUtils.copyProperties(transaction, transactionResponse);
        transactionResponse.setAccountId(transaction.getAccount().getId());
        transactionResponse.setAccountNumber(transaction.getAccount().getAccountNumber());
        transactionResponse.setAccountName(transaction.getAccount().getAccountName());
        return transactionResponse;
    }
}
