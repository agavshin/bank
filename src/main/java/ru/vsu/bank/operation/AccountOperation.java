package ru.vsu.bank.operation;

import ru.vsu.bank.domain.User;
import ru.vsu.bank.store.AccountManager;

import java.util.Date;

/**
 * @author agavshin
 * @date 27.09.18
 */
public abstract class AccountOperation {

    protected User user;

    protected Date createdAt = new Date();

    protected AccountManager accountManager = AccountManager.getInstance();

    public AccountOperation(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public abstract String message();

    public abstract void handle();
}
