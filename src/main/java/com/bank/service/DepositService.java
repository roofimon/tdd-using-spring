/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.service;

import com.bank.domain.DepositReceipt;
import com.bank.domain.InvalidDepositAmountException;

/**
 *
 * @author TwinP
 */
public interface DepositService {
    void setMinimumDepositAmount(double minimumDepositAmount);
    public DepositReceipt deposit(double amount, String destrinationAcc) throws InvalidDepositAmountException;
}
