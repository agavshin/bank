package ru.vsu.bank;

import ru.vsu.bank.operation.AccountOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author agavshin
 * @date 27.09.18
 */
public class OperationManager {

    private static OperationManager instance;

    public static OperationManager getInstance() {
        if (instance == null) {
            instance = new OperationManager();
        }
        return instance;
    }

    private List<AccountOperation> operations = new ArrayList<>();

    private OperationManager() {

    }

    public void execute(AccountOperation operation) {
        operation.handle();
        operations.add(operation);
    }

    public List<AccountOperation> getOperations() {
        return operations;
    }
}
