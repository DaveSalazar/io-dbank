package com.application.administration.core.setting.infrastructure.persistence;

import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingRepository;
import com.application.administration.core.shared.domain.Service;
import com.application.administration.core.shared.domain.criteria.Criteria;
import com.application.administration.core.shared.domain.identifiers.SettingId;
import com.application.administration.core.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HibernateSettingRepository extends HibernateRepository<Setting> implements SettingRepository {

    public HibernateSettingRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Setting.class);
    }

    @Override
    public void save(Setting data) {
        persist(data);
    }

    @Override
    public Optional<Setting> search(SettingId id) {
        return byId(id);
    }

    @Override
    public List<Setting> searchAll() {
        return all();
    }

    @Override
    public List<Setting> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
