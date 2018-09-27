package ru.vsu.bank;

import ru.vsu.bank.domain.User;
import ru.vsu.bank.operation.CreateAccountOperation;
import ru.vsu.bank.operation.AccountOperation;
import ru.vsu.bank.operation.DeleteOperation;
import ru.vsu.bank.operation.ListAccountsOperation;
import ru.vsu.bank.store.UserManager;

import java.util.Scanner;

/**
 * @author agavshin
 * @date 26.09.18
 */
public class BankTerminal {

    private Scanner in = new Scanner(System.in);

    private UserManager userStore = UserManager.getInstance();

    private OperationManager operationManager = OperationManager.getInstance();

    public void activate() {
        while (true) {
            System.out.println("===== Bank User Menu =====");
            System.out.println("1 - Register");
            System.out.println("2 - Login ");
            System.out.println("10 - Exit ");
            System.out.println("==========================\n");

            int command = in.nextInt();

            switch (command) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    User user = login();
                    showAccountMenu(user);
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        }
    }

    private void showAccountMenu(User user) {
        while (user != null) {
            System.out.println("===== Bank Account Menu =====");
            System.out.println("1 - Create new account");
            System.out.println("2 - Delete account");
            System.out.println("3 - List of accounts");
            System.out.println("10 - Logout");
            System.out.println("=============================\n");

            int command = in.nextInt();
            switch (command) {
                case 1:
                    createAccount(user);
                    break;
                case 2:
                    deleteAccount(user);
                    break;
                case 3:
                    showAccountsList(user);
                    break;
                case 10:
                    user = null;
                    break;
            }
        }
    }

    private void showAccountsList(User user) {
        System.out.println("Accounts list");
        AccountOperation listAccountsOperation = new ListAccountsOperation(user);
        operationManager.execute(listAccountsOperation);
    }

    private void deleteAccount(User user) {
        System.out.println("Select account uid from list to delete.");
        showAccountsList(user);
        String uid = in.next();
        AccountOperation deleteOperation = new DeleteOperation(user, uid);
        operationManager.execute(deleteOperation);
    }

    private void createAccount(User user) {
        AccountOperation createOperation = new CreateAccountOperation(user);
        operationManager.execute(createOperation);
    }

    private User login() {
        System.out.println("Enter login: ");
        String login = in.next();
        System.out.println("Enter password: ");
        String password = in.next();

        User user = userStore.getUser(login, password);
        if (user == null) {
            System.out.println("Bad credentials.");
        }
        return user;
    }

    private void registerUser() {
        System.out.println("Enter user login: ");
        String login = in.next();
        System.out.println("Enter user pass: ");
        String password = in.next();

        User user = new User(login, password);
        userStore.addUser(user);
        System.out.println("User has been created successfully.");
    }

}
