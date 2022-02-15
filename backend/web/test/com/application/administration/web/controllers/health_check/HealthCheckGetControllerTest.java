package com.application.administration.web.controllers.health_check;

import com.application.administration.web.controllers.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

class HealthCheckGetControllerTest extends ApplicationTestCase {

    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}