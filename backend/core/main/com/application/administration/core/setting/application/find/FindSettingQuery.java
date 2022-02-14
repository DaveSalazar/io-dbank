package com.application.administration.core.setting.application.find;

import com.application.administration.core.shared.domain.bus.query.Query;

public final class FindSettingQuery implements Query {
    private final String id;

    public FindSettingQuery(String id) {this.id = id;}

    public String id() {
        return id;
    }
}
