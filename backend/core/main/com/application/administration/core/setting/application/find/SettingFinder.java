package com.application.administration.core.setting.application.find;

import com.application.administration.core.setting.domain.SettingNotExists;
import com.application.administration.core.setting.domain.SettingRepository;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.setting.application.SettingResponse;

@Service
public final class SettingFinder  {

    private final SettingRepository repository;

    public SettingFinder(SettingRepository repository) {this.repository = repository;}

    public SettingResponse find(SettingId id) {
        return repository.search(id).map(SettingResponse::fromAggregate)
                         .orElseThrow(()-> new SettingNotExists(id));
    }
}
