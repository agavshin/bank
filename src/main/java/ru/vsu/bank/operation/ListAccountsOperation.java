package ru.vsu.bank.operation;

import ru.vsu.bank.domain.Account;
import ru.vsu.bank.domain.User;

/**
 * @author agavshin
 * @date 27.09.18
 */
public class ListAccountsOperation extends AccountOperation {

    public ListAccountsOperation(User user) {
        super(user);
    }

    @Override
    public String message() {
        return user.getLogin() + " requested list of accounts at " + createdAt + ".";
    }

    @Override
    public void handle() {
        accountManager.getUserAccounts(user).stream()
                .map(Account::toString)
                .forEach(System.out::println);
    }
}
