package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;


public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        boolean accNotFind = true;
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.equals(account)) {
                    accNotFind = false;
                    break;
                }
            }
        }
        if (user != null && accNotFind) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        return Stream.of(findByPassport(passport))
                .filter(Objects::nonNull)
                .flatMap(u -> users.get(u).stream())
                .filter(req -> req.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
