package com.application.administration.core.setting.domain;

import com.application.administration.core.shared.domain.criteria.Criteria;
import com.application.administration.core.shared.domain.identifiers.SettingId;

import java.util.List;
import java.util.Optional;

public interface SettingRepository {
    void save(Setting data);
    Optional<Setting> search(SettingId id);
    List<Setting> searchAll();
    List<Setting> matching(Criteria criteria);
}
