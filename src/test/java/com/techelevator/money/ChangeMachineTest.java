package com.techelevator.money;

import com.techelevator.inventory.Candy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.inventory.Item;
import com.techelevator.money.ChangeMachine;

import java.math.BigDecimal;

public class ChangeMachineTest {

    @Before
    public void setup() {
        ChangeMachine changeMachine = new ChangeMachine();
    }

    @Test
    public void Each_Dollar_Change_Test() {

        ChangeMachine changeMachine = new ChangeMachine();
        changeMachine.makeChange(new BigDecimal("1.65"));

        Assert.assertEquals("Returning change: " + 1 + " $1(s), " + 2 + " quarter(s), " + 1 + " dime(s), " + 1 + " nickel(s).",
                "Returning change: " + changeMachine.getCountOfDollars() + " $1(s), " + changeMachine.getCountOfQuarters() + " quarter(s), " + changeMachine.getCountOfDimes() + " dime(s), " + changeMachine.getCountOfNickels() + " nickel(s).");

    }


}
