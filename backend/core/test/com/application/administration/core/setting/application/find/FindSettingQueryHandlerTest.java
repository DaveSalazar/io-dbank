package com.application.administration.core.setting.application.find;

import com.application.administration.core.setting.SettingModuleUnitTestCase;
import com.application.administration.core.setting.application.SettingResponse;
import com.application.administration.core.setting.application.SettingResponseMother;
import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSettingQueryHandlerTest extends SettingModuleUnitTestCase {
    FindSettingQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new FindSettingQueryHandler(new SettingFinder(repository));
    }

    @Test
    void it_should_find_an_existing_setting() {
        Setting setting  = SettingMother.random();
        FindSettingQuery query    = new FindSettingQuery(setting.id().value());
        SettingResponse response = SettingResponseMother.create(setting.id(), setting.userId(), setting.name(), setting.value());

        shouldSearch(setting);

        assertEquals(response, handler.handle(query));
    }
}