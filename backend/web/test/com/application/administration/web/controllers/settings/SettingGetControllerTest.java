package com.application.administration.web.controllers.settings;

import com.application.administration.web.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class SettingGetControllerTest extends ApplicationTestCase {
    @Test
    void find_an_existing_setting() throws Exception {
        String id   = "99ad55f5-6eab-4d73-b383-c63268e251e8";
        String body = "{\"name\": \"The best setting\", \"value\": \"5 hours\"}";

        givenThereIsASetting(id, body);

        assertResponse(String.format("/settings/%s", id), 200, body);
    }

    @Test
    void no_find_a_non_existing_setting() throws Exception {
        String id   = "4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661";
        String body = "{\"error_code\": \"setting_not_exist\", \"message\": \"The setting <4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661> doesn't exist\"}";

        assertResponse(String.format("/courses/%s", id), 404, body);
    }

    private void givenThereIsASetting(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/courses/%s", id), body, 201);
    }
}