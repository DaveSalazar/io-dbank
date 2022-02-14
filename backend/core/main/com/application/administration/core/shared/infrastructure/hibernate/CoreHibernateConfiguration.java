package com.application.administration.core.shared.infrastructure.hibernate;

import com.application.administration.core.shared.infrastructure.config.Parameter;
import com.application.administration.core.shared.infrastructure.config.ParameterNotExist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class CoreHibernateConfiguration {

    private final Parameter config;
    private final HibernateConfigurationFactory factory;

    public CoreHibernateConfiguration(Parameter config, HibernateConfigurationFactory factory) {
        this.config = config;
        this.factory = factory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() throws ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws ParameterNotExist {
        return factory.sessionFactory(dataSource());
    }

    @Bean
    public DataSource dataSource() throws ParameterNotExist {
        return factory.dataSource(
                config.get("DATABASE_HOST"),
                config.getInt("DATABASE_PORT"),
                config.get("DATABASE_NAME"),
                config.get("DATABASE_USER"),
                config.get("DATABASE_PASSWORD")
        );
    }
}
