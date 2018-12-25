/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bank.domain;

/**
 *
 * @author TwinP
 */
public class DepositReceipt {
    private double depositAmount;
    private Account initialDestinationAccountCopy;
    private Account finalDestinationAccountCopy;

    /**
     * @return the depositAmount
     */
    public double getDepositAmount() {
        return depositAmount;
    }

    /**
     * @param depositAmount the depositAmount to set
     */
    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    /**
     * @return the initialDestinationAccountCopy
     */
    public Account getInitialDestinationAccountCopy() {
        return initialDestinationAccountCopy;
    }

    /**
     * @param initialDestinationAccountCopy the initialDestinationAccountCopy to set
     */
    public void setInitialDestinationAccountCopy(Account initialDestinationAccountCopy) {
        this.initialDestinationAccountCopy = initialDestinationAccountCopy;
    }

    /**
     * @return the finalDestinationAccountCopy
     */
    public Account getFinalDestinationAccountCopy() {
        return finalDestinationAccountCopy;
    }

    /**
     * @param finalDestinationAccountCopy the finalDestinationAccountCopy to set
     */
    public void setFinalDestinationAccountCopy(Account finalDestinationAccountCopy) {
        this.finalDestinationAccountCopy = finalDestinationAccountCopy;
    }

    @Override
    public String toString() {
        return "DepositReceipt{" + "depositAmount=" + depositAmount +  "initialDestinationAccountCopy=" + initialDestinationAccountCopy + "finalDestinationAccountCopy=" + finalDestinationAccountCopy + '}';
    }

    
}
