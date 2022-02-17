package com.application.administration.core.account.domain;

import com.application.administration.core.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Account extends AggregateRoot {

    private final AccountAddress address;

    public Account(AccountAddress address) {
        this.address = address;
    }
    private Account() {
        this.address = null;
    }

    public static Account fromPrimitives(String address) {
        return new Account(new AccountAddress(address));
    }

    public AccountAddress address() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(address, account.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
