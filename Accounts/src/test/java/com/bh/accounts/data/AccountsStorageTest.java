package com.bh.accounts.data;

import com.bh.accounts.dto.Account;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AccountsStorageTest {
    @Test
    public void testAddGetDelete() {
        String account11Id = AccountsStorage.addAccount("Customer1", "Name11");
        String account21Id = AccountsStorage.addAccount("Customer2", "Name21");
        String account12Id = AccountsStorage.addAccount("Customer1", "Name12");

        Optional<List<Account>> result = AccountsStorage.getAccounts("Customer1");

        assertEquals(2, result.get().size());
        assertEquals("Name11", result.get().get(0).getName());
        assertEquals("Name12", result.get().get(1).getName());

        AccountsStorage.deleteAccount("Customer1", account11Id);

        result = AccountsStorage.getAccounts("Customer1");

        assertEquals(1, result.get().size());
        assertEquals("Name12", result.get().get(0).getName());

        assertEquals(Optional.empty(), AccountsStorage.getAccounts("XXX"));

    }
}
