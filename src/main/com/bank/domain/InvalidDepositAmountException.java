/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.domain;

/**
 *
 * @author TwinP
 */
public class InvalidDepositAmountException extends Exception {
    private double attemptedAmount;
    /**
     * Creates a new instance of <code>InvalidDepositAmountException</code> without detail message.
     */
    public InvalidDepositAmountException(double attemptedAmount) {
                this.attemptedAmount = attemptedAmount;
    }

    /**
     * @return the attemptedAmount
     */
    public double getAttemptedAmount() {
        return attemptedAmount;
    }

    /**
     * @param attemptedAmount the attemptedAmount to set
     */
    public void setAttemptedAmount(double attemptedAmount) {
        this.attemptedAmount = attemptedAmount;
    }

    @Override
    public String toString() {
        return "InvalidDepositAmountException{" + "attemptedAmount=" + attemptedAmount + '}';
    }

    
}
