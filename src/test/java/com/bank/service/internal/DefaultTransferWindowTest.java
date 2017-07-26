package com.bank.service.internal;

import com.bank.domain.LocalTimeWrapper;
import com.bank.domain.DefaultTransferWindow;
import org.junit.Assert;
import org.junit.Test;

public class DefaultTransferWindowTest {
    @Test
    public void withinValidTransferWindow() {
        LocalTimeWrapper x = new LocalTimeWrapper();
        LocalTimeWrapper localTimeWrapper = new LocalTimeWrapper("12:05:59");
        DefaultTransferWindow transferWindow = new DefaultTransferWindow("10:00:00", "22:00:00");
        Assert.assertTrue(transferWindow.isValidTimeForTransferMoney(localTimeWrapper.getCurrentTime()));
    }

    @Test
    public void withinInValidTransferWindow() {
        LocalTimeWrapper localTimeWrapper = new LocalTimeWrapper("23:00:00");
        DefaultTransferWindow transferWindow = new DefaultTransferWindow("10:00:00", "22:00:00");
        Assert.assertFalse(transferWindow.isValidTimeForTransferMoney(localTimeWrapper.getCurrentTime()));
    }

}
