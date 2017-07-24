package com.bank.service.internal;

import com.bank.domain.CurrentTime;
import com.bank.domain.DefaultTransferWindow;
import org.junit.Assert;
import org.junit.Test;

public class DefaultTransferWindowTest {
    //private final
    @Test
    public void withinValidTransferWindow() {
        CurrentTime currentTime = new CurrentTime("12:05:59");
        DefaultTransferWindow transferWindow = new DefaultTransferWindow("10:00:00", "22:00:00");
        Assert.assertTrue(transferWindow.isValidTimeForTransferMoney(currentTime.getCurrentTime()));
    }

    @Test
    public void withinInValidTransferWindow() {
        CurrentTime currentTime = new CurrentTime("23:00:00");
        DefaultTransferWindow transferWindow = new DefaultTransferWindow("10:00:00", "22:00:00");
        Assert.assertFalse(transferWindow.isValidTimeForTransferMoney(currentTime.getCurrentTime()));
    }

}
