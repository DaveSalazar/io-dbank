package com.application.administration.web.controllers.settings;

import com.application.administration.web.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class SettingPutControllerTest extends ApplicationTestCase {

    @Test
    void create_a_valid_non_existing_setting() throws Exception {
        assertRequestWithBody(
                "PUT",
                PREFIX + "/settings/1aab45ba-3c7a-4344-8936-78466eca77fa",
                "{\"name\": \"The best course\", \"value\": \"5 hours\"}",
                201
        );
    }

}