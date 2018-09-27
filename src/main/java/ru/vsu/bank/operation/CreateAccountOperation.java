package ru.vsu.bank.operation;

import ru.vsu.bank.domain.Account;
import ru.vsu.bank.domain.User;

/**
 * @author agavshin
 * @date 27.09.18
 */
public class CreateAccountOperation extends AccountOperation {

    public CreateAccountOperation(User user) {
        super(user);
    }

    @Override
    public String message() {
        return user.getLogin() + " created an account at " + createdAt + ".";
    }

    @Override
    public void handle() {
        Account newAccount = new Account(user);
        accountManager.addAccount(newAccount);
    }
}
