package com.application.administration.core.account.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountRepository {
    List<Account> searchAll();
    Optional<Account> find(Account data);
    Map<String, Serializable> create(String userId);
}
