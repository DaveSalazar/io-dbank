package com.application.administration.core.setting.application.save;

import com.application.administration.core.setting.SettingModuleUnitTestCase;
import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SaveSettingCommandHandlerTest extends SettingModuleUnitTestCase {

    private SaveSettingCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new SaveSettingCommandHandler(new SettingSave(repository, eventBus));
    }


    @Test
    void create_a_valid_setting() {
        SaveSettingCommand command = SaveSettingCommandMother.random();

        Setting setting      = SettingMother.fromRequest(command);

        handler.handle(command);

        shouldHaveSaved(setting);
    }
}