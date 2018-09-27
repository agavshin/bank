package ru.vsu.bank.operation;

import ru.vsu.bank.domain.Account;
import ru.vsu.bank.domain.User;

import java.util.Optional;

/**
 * @author agavshin
 * @date 27.09.18
 */
public class DeleteOperation extends AccountOperation {

    private Account account;

    public DeleteOperation(User user) {
        super(user);
    }

    public DeleteOperation(User user, String accountUid) {
        this(user);
        this.account = accountManager.getUserAccounts(user).stream()
                .filter(a -> a.getUid().equals(accountUid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String message() {
        return user.getLogin() + " deleted account at " + createdAt + ".";
    }

    @Override
    public void handle() {
        accountManager.deleteAccount(account);
    }
}
