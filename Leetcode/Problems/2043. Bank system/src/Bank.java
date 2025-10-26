import java.util.*;

class Bank {
    LinkedHashMap<Integer, Long> accounts;

    public Bank(long[] balance) {
        this.accounts = new LinkedHashMap<>();

        for (int i = 0; i < balance.length; i++) {
            this.accounts.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if(!accounts.containsKey(account1) || !accounts.containsKey(account2)) return false;

        if(withdraw(account1, money)) {
            return deposit(account2, money);
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(accounts.containsKey(account)){
            accounts.put(account, (accounts.get(account) + money));
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(accounts.containsKey(account) && accounts.get(account) >= money){
            accounts.put(account, accounts.get(account) - money);
            return true;
        }
        return false;
    }
}

/*
    No need to use a LinkedHashMap, i didnt understand how i got input.

    Solution:
    class Bank {

    long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (
            account1 > balance.length ||
            account2 > balance.length ||
            balance[account1 - 1] < money
        ) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > balance.length) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > balance.length || balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
 */