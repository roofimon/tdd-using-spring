/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service.internal;
import static java.lang.String.format;

import com.bank.domain.Account;
import com.bank.domain.DepositReceipt;
import com.bank.domain.InvalidDepositAmountException;
import com.bank.repository.AccountRepository;
import com.bank.service.DepositService;
import com.bank.service.FeePolicy;

/**
 *
 * @author TwinP
 */
public class DefaultDepositService implements DepositService {

    private final AccountRepository accountRepository;
    private final FeePolicy feePolicy;
    private double minimumDepositAmount = 1.00;

    public DefaultDepositService(AccountRepository accountRepository, FeePolicy feePolicy) {
        this.accountRepository = accountRepository;
        this.feePolicy = feePolicy;
    }

    @Override
    public void setMinimumDepositAmount(double minimumDepositAmount) {
        this.minimumDepositAmount = minimumDepositAmount;
    }

    @Override
    public DepositReceipt deposit(double amount, String destrinationAccountNumber) throws InvalidDepositAmountException {
        if (amount <= this.minimumDepositAmount) {
            throw new InvalidDepositAmountException(amount);
        }
        DepositReceipt depositReceipt = new DepositReceipt();
        Account destrinationAccount = accountRepository.findById(destrinationAccountNumber);

        depositReceipt.setDepositAmount(amount);
        depositReceipt.setInitialDestinationAccountCopy(destrinationAccount);

        destrinationAccount.credit(amount);
        accountRepository.updateBalance(destrinationAccount);

        depositReceipt.setFinalDestinationAccountCopy(destrinationAccount);
        return depositReceipt;
    }
}
