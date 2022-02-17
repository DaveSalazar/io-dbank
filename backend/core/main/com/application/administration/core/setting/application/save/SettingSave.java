package com.application.administration.core.setting.application.save;

import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingRepository;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.event.EventBus;

@Service
public final class SettingSave {

    private final SettingRepository repository;
    private final EventBus                        eventBus;

    public SettingSave(SettingRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void save(Setting setting) {
        repository.save(setting);
        eventBus.publish(setting.pullDomainEvents());
    }
}
