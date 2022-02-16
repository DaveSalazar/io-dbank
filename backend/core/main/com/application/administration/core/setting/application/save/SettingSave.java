package com.application.administration.core.setting.application.save;

import com.application.administration.core.setting.domain.AdministrationSetting;
import com.application.administration.core.setting.domain.AdministrationSettingRepository;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.event.EventBus;

@Service
public final class SettingSave {

    private final AdministrationSettingRepository repository;
    private final EventBus                        eventBus;

    public SettingSave(AdministrationSettingRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void save(AdministrationSetting setting) {
        repository.save(setting);
        eventBus.publish(setting.pullDomainEvents());
    }
}
