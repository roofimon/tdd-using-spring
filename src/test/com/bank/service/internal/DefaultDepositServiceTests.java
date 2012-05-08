/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.service.internal;

import com.bank.domain.InvalidDepositAmountException;
import static com.bank.repository.internal.SimpleAccountRepository.Data.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.bank.repository.AccountRepository;
import com.bank.repository.internal.SimpleAccountRepository;
import com.bank.service.DepositService;
import com.bank.service.FeePolicy;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author TwinP
 */
public class DefaultDepositServiceTests {

    private AccountRepository accountRepository;
    private DepositService depositService;

    @Before
    public void setUp() {
        accountRepository = new SimpleAccountRepository();
        FeePolicy feePolicy = new ZeroFeePolicy();
        depositService = new DefaultDepositService(accountRepository, feePolicy);

        assertThat(accountRepository.findById(A123_ID).getBalance(), equalTo(A123_INITIAL_BAL));
        assertThat(accountRepository.findById(C456_ID).getBalance(), equalTo(C456_INITIAL_BAL));
    }

    @Test
    public void testDeposit() {
        double depositAmount = 100.00;
        depositService.setMinimumDepositAmount(5.00);
        try {
            depositService.deposit(depositAmount, A123_ID);
        } catch (InvalidDepositAmountException error) {
        }
        assertThat(accountRepository.findById(A123_ID).getBalance(), equalTo(A123_INITIAL_BAL + depositAmount));
    }

    @Test
    public void testDepositBelowMinimumAmount() throws InvalidDepositAmountException {
        double depositAmount = 4.99;
        depositService.setMinimumDepositAmount(5.00);
        try {
            depositService.deposit(depositAmount, A123_ID);
            fail("expected InvalidDepositAmountException");
        } catch (InvalidDepositAmountException error) {
            assertThat(error.getAttemptedAmount(), equalTo(depositAmount));
        }
        assertThat(accountRepository.findById(A123_ID).getBalance(), equalTo(A123_INITIAL_BAL));
    }
}
