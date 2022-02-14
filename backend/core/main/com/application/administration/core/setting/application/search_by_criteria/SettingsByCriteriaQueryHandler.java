package com.application.administration.core.setting.application.search_by_criteria;

import com.application.administration.core.setting.application.SettingsResponse;
import com.application.administration.core.shared.domain.criteria.FilterOrder;
import com.application.administration.core.shared.domain.criteria.Filters;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.bus.query.QueryHandler;

@Service
public final class SettingsByCriteriaQueryHandler implements QueryHandler<SettingsByCriteriaQuery, SettingsResponse> {
    private final SettingsByCriteriaSearcher searcher;

    public SettingsByCriteriaQueryHandler(SettingsByCriteriaSearcher searcher) {this.searcher = searcher;}


    @Override
    public SettingsResponse handle(SettingsByCriteriaQuery query) {

        Filters filters = Filters.fromValues(query.filters());
        FilterOrder order   = FilterOrder.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
