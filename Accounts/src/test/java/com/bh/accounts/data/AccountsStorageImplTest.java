package com.bh.accounts.data;

import com.bh.accounts.dto.Account;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class AccountsStorageImplTest {
    @Test
    public void testAddGetDelete() {
        AccountsStorage accountsStorage = new AccountsStorageImpl();

        String account11Id = accountsStorage.addAccount("Customer1", "Name11");
        String account21Id = accountsStorage.addAccount("Customer2", "Name21");
        String account12Id = accountsStorage.addAccount("Customer1", "Name12");

        Optional<List<Account>> result = accountsStorage.getAccounts("Customer1");

        assertEquals(2, result.get().size());
        assertEquals("Name11", result.get().get(0).getName());
        assertEquals("Name12", result.get().get(1).getName());

        accountsStorage.deleteAccount("Customer1", account11Id);

        result = accountsStorage.getAccounts("Customer1");

        assertEquals(1, result.get().size());
        assertEquals("Name12", result.get().get(0).getName());

        assertEquals(Optional.empty(), accountsStorage.getAccounts("XXX"));

    }
}
