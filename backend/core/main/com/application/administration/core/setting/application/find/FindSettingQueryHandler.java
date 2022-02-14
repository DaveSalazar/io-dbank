package com.application.administration.core.setting.application.find;

import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.setting.application.SettingResponse;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.query.QueryHandler;

@Service
public final class FindSettingQueryHandler implements QueryHandler<FindSettingQuery, SettingResponse> {

    private final SettingFinder finder;

    public FindSettingQueryHandler(SettingFinder finder) {this.finder = finder;}

    @Override
    public SettingResponse handle(FindSettingQuery query) {
        return finder.find(new AdministrationSettingId(query.id()));
    }
}
