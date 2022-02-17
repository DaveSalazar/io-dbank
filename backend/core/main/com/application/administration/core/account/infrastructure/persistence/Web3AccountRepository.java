package com.application.administration.core.account.infrastructure.persistence;

import com.application.administration.core.account.domain.Account;
import com.application.administration.core.account.domain.AccountRepository;
import com.application.administration.core.account.domain.CannotCreateAccount;
import com.application.administration.core.shared.domain.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Web3AccountRepository implements AccountRepository {
    private final Web3j web3j;

    public Web3AccountRepository(Web3j web3j) {
        this.web3j = web3j;
    }

    @Override
    public List<Account> searchAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            accounts = web3j.ethAccounts().send()
                    .getAccounts()
                    .stream().map(Account::fromPrimitives).collect(Collectors.toList());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Optional<Account> find(Account data) {
        return Optional.empty();
    }

    @Override
    public Map<String, Serializable> create(String userId) {
        Map<String, Serializable> data = new HashMap<>();
        String walletDirectory = "D:\\io_builders_dbank\\backend\\wallets";

        String walletName;
        String accountAddress = null;
        try {
            walletName = WalletUtils.generateNewWalletFile(userId, new File(walletDirectory));
            System.out.println("wallet location: " + walletDirectory + "/" + walletName);
            Credentials credentials = WalletUtils.loadCredentials(userId, walletDirectory + "/" + walletName);

            accountAddress = credentials.getAddress();
            data.put("address", accountAddress);
            data.put("wallet", walletName);
        } catch (Exception e) {
           throw new CannotCreateAccount(userId);
        }

        return data;
    }
}
