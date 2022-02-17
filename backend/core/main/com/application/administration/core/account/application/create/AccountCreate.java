package com.application.administration.core.account.application.create;

import com.application.administration.core.account.domain.AccountRepository;
import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingName;
import com.application.administration.core.setting.domain.SettingRepository;
import com.application.administration.core.setting.domain.SettingValue;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.shared.domain.identifiers.UserId;

import java.util.UUID;

@Service
public final class AccountCreate {

    private final AccountRepository repository;
    private final SettingRepository settingRepository;

    public AccountCreate(AccountRepository repository, SettingRepository settingRepository) {
        this.repository = repository;
        this.settingRepository = settingRepository;
    }

    public void create(String userId) {
        var acc = repository.create(userId);
        this.settingRepository.save(accountAddressUserSetting(userId, (String) acc.get("address")));
        this.settingRepository.save(accountWalletUserSetting(userId, (String) acc.get("wallet")));
    }

    private Setting accountAddressUserSetting(String strUserId, String address) {
        var id = new SettingId(UUID.randomUUID().toString());
        var userId =  new UserId(strUserId);
        var name = new SettingName("accountAddress");
        var value =  new SettingValue(address);
        return new Setting(id, userId, name, value);
    }

    private Setting accountWalletUserSetting(String strUserId, String wallet) {
        var id = new SettingId(UUID.randomUUID().toString());
        var userId =  new UserId(strUserId);
        var name = new SettingName("accountWallet");
        var value =  new SettingValue(wallet);
        return new Setting(id, userId, name, value);
    }
}
