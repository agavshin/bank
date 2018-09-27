package ru.vsu.bank.store;

import ru.vsu.bank.domain.Account;
import ru.vsu.bank.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author agavshin
 * @date 27.09.18
 */
public class AccountManager {

    private static AccountManager instance;

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    private List<Account> accounts = new ArrayList<>();

    private AccountManager() {
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public List<Account> getUserAccounts(User user) {
        return accounts.stream()
                .filter(a -> a.getOwner().equals(user))
                .collect(Collectors.toList());
    }
}
