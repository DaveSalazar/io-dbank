package com.application.administration.core.setting.application.save;

import com.application.administration.core.setting.domain.AdministrationSetting;
import com.application.administration.core.setting.domain.AdministrationSettingName;
import com.application.administration.core.setting.domain.AdministrationSettingValue;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.command.CommandHandler;
import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.shared.domain.identifiers.UserId;

@Service
public final class SaveSettingCommandHandler implements CommandHandler<SaveSettingCommand> {
    
    private final SettingSave save;

    public SaveSettingCommandHandler(SettingSave save) {this.save = save;}

    @Override
    public void handle(SaveSettingCommand command) {
        var id = new AdministrationSettingId(command.id());
        var userId = new UserId(command.userId());
        var name = new AdministrationSettingName(command.name());
        var value = new AdministrationSettingValue(command.value());

        var setting = AdministrationSetting.create(id, userId, name, value);
        save.save(setting);
    }
}
