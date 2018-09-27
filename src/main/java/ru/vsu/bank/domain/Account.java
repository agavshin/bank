package ru.vsu.bank.domain;

/**
 * @author agavshin
 * @date 26.09.18
 */
public class Account {

    private User owner;

    private String uid;

    private float money;

    public Account(User user) {
        this.owner = user;
        this.uid = generateUid();
    }

    public Account(User user, float money) {
        this(user);
        this.money = money;
    }

    private String generateUid() {
        return String.valueOf(System.currentTimeMillis());
    }

    public User getOwner() {
        return owner;
    }

    public String getUid() {
        return uid;
    }

    public float getMoney() {
        return money;
    }

    public void deposit(float money) {
        this.money += money;
    }

    public float withdraw(float money) {
        if (this.money == 0) {
            return -1;
        }
        float res = this.money - money;
        if (res < 0) {
            return -1;
        } else {
            this.money = res;
        }
        return res;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid='" + uid + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
