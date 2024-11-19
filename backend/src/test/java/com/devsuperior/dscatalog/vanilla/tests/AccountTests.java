package com.devsuperior.dscatalog.vanilla.tests;

import com.devsuperior.dscatalog.vanilla.entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        // Arrange
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = new Account(1L, 0.0);
        // Act
        acc.deposit(200.0);
        // Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

}
