package com.techelevator.money;

import com.techelevator.inventory.Candy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import com.techelevator.inventory.Item;

import java.math.BigDecimal;

public class UserWalletTest {

    @Test
    public void add_35_to_balance() {
        UserWallet.addToUserMoney("20");
        UserWallet.addToUserMoney("10");
        UserWallet.addToUserMoney("5");
        UserWallet.addToUserMoney("1");
        Assert.assertEquals(new BigDecimal("36.00"),UserWallet.getUserMoney());
    }

    @Test
    public void purchase_test() {
        UserWallet.addToUserMoney("10");
        Item result = new Candy("Snorker",new BigDecimal("3.50"), "A1");
        UserWallet.purchaseFromUserMoney(result);

        Assert.assertEquals(new BigDecimal("6.50"), UserWallet.getUserMoney());
    }

    @After
    public void setter() {
        UserWallet.setUserMoney(new BigDecimal("0.00"));
    }

}
