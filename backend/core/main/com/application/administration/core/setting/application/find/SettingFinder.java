package com.application.administration.core.setting.application.find;

import com.application.administration.core.setting.domain.AdministrationSettingNotExists;
import com.application.administration.core.setting.domain.AdministrationSettingRepository;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.setting.application.SettingResponse;

@Service
public final class SettingFinder  {

    private final AdministrationSettingRepository repository;

    public SettingFinder(AdministrationSettingRepository repository) {this.repository = repository;}

    public SettingResponse find(AdministrationSettingId id) {
        return repository.search(id).map(SettingResponse::fromAggregate)
                         .orElseThrow(()-> new AdministrationSettingNotExists(id));
    }
}
