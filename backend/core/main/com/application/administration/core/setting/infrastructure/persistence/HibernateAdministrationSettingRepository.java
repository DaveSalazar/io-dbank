package com.application.administration.core.setting.infrastructure.persistence;

import com.application.administration.core.setting.domain.AdministrationSettingRepository;
import com.application.administration.core.shared.domain.identifiers.AdministrationSettingId;
import com.application.administration.core.shared.infrastructure.hibernate.HibernateRepository;
import com.application.administration.core.setting.domain.AdministrationSetting;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.criteria.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HibernateAdministrationSettingRepository extends HibernateRepository<AdministrationSetting>
        implements AdministrationSettingRepository {

    public HibernateAdministrationSettingRepository(SessionFactory sessionFactory) {
        super(sessionFactory, AdministrationSetting.class);
    }

    @Override
    public void save(AdministrationSetting data) {
        persist(data);
    }

    @Override
    public Optional<AdministrationSetting> search(AdministrationSettingId id) {
        return byId(id);
    }

    @Override
    public List<AdministrationSetting> searchAll() {
        return all();
    }

    @Override
    public List<AdministrationSetting> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
