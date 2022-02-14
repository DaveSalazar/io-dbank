package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface AdministrationSettingRepository {
    void save(AdministrationSetting data);
    Optional<AdministrationSetting> search(AdministrationSettingId id);
    List<AdministrationSetting> searchAll();
    List<AdministrationSetting> matching(Criteria criteria);
}
