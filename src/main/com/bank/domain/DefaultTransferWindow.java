package com.bank.domain;

import java.time.LocalTime;

public class DefaultTransferWindow {
    private LocalTime open;
    private LocalTime close;
    public DefaultTransferWindow(String open, String close) {
        this.open = LocalTime.parse(open);
        this.close = LocalTime.parse(close);
    }

    public boolean isValidTimeForTransferMoney(LocalTime transactionTime) {
        return (transactionTime.isAfter(open))&&(transactionTime.isBefore(close));
    }
}
