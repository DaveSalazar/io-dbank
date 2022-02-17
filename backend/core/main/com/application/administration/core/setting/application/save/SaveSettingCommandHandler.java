package com.application.administration.core.setting.application.save;

import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingName;
import com.application.administration.core.setting.domain.SettingValue;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.command.CommandHandler;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.shared.domain.identifiers.UserId;

@Service
public final class SaveSettingCommandHandler implements CommandHandler<SaveSettingCommand> {
    
    private final SettingSave save;

    public SaveSettingCommandHandler(SettingSave save) {this.save = save;}

    @Override
    public void handle(SaveSettingCommand command) {
        var id = new SettingId(command.id());
        var userId = new UserId(command.userId());
        var name = new SettingName(command.name());
        var value = new SettingValue(command.value());

        var setting = Setting.create(id, userId, name, value);
        save.save(setting);
    }
}
