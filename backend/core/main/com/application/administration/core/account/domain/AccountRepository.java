package com.application.administration.core.account.domain;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> searchAll();
    Optional<Account> find(Account data);
}
