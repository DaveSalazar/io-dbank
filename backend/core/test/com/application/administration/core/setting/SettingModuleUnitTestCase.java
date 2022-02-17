package com.application.administration.core.setting;

import com.application.administration.core.setting.domain.Setting;
import com.application.administration.core.setting.domain.SettingRepository;
import com.application.administration.core.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class SettingModuleUnitTestCase extends UnitTestCase {

    protected SettingRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(SettingRepository.class);
    }

    public void shouldHaveSaved(Setting setting) {
        verify(repository, atLeastOnce()).save(setting);
    }

    public void shouldSearch(Setting setting) {
        Mockito.when(repository.search(setting.id())).thenReturn(Optional.of(setting));
    }
}
