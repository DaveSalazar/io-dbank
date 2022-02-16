package com.application.administration.core.setting.application.search_by_criteria;

import com.application.administration.core.setting.application.SettingsResponse;
import com.application.administration.core.setting.domain.AdministrationSettingRepository;
import com.application.administration.core.shared.domain.criteria.FilterOrder;
import com.application.administration.core.shared.domain.criteria.Filters;
import com.application.administration.core.setting.application.SettingResponse;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.criteria.Criteria;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class SettingsByCriteriaSearcher {
    private final AdministrationSettingRepository repository;

    public SettingsByCriteriaSearcher(AdministrationSettingRepository repository) {this.repository = repository;}

    public SettingsResponse search(
            Filters filters,
            FilterOrder order,
            Optional<Integer> limit,
            Optional<Integer> offset) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new SettingsResponse(
                repository.matching(criteria)
                          .stream()
                          .map(SettingResponse::fromAggregate)
                          .collect(Collectors.toList())
        );
    }
}
