package com.application.administration.core.shared.infrastructure.hibernate;

import com.application.administration.core.shared.domain.Constants;
import com.application.administration.core.shared.domain.Service;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;

@Service
public final class HibernateConfigurationFactory {

    Logger logger = LoggerFactory.getLogger(HibernateConfigurationFactory.class);

    private final ResourcePatternResolver resourceResolver;

    public HibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        logger.trace("Configuring hibernate");
        this.resourceResolver = resourceResolver;
    }

    public PlatformTransactionManager hibernateTransactionManager(LocalSessionFactoryBean sessionFactory) {
        var transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());

        return transactionManager;
    }

    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(hibernateProperties());

        List<Resource> mappingFiles = searchMappingFiles();
        var resources = new Resource[mappingFiles.size()];
        var mappings = mappingFiles.toArray(resources);
        sessionFactory.setMappingLocations(mappings);

        return sessionFactory;
    }

    public DataSource dataSource(
        String host,
        Integer port,
        String databaseName,
        String username,
        String password
    ) {
        var dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        dataSource.setUrl(
            String.format(
                "jdbc:postgresql://%s:%s/%s",
                host,
                port,
                databaseName
            )
        );
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    private List<Resource> searchMappingFiles() {
        List<String> modules   = subdirectoriesFor();
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infrastructure/persistence/hibernate/");
            logger.info(String.format("Module: %s has %s files", module, files.length));
            for (String file : files) {
                logger.info(String.format("hibernate file: %s", file));
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor() {

        var path = String.format("./core/main/com/%s/%s/core/", Constants.APP_NAME, Constants.MODULE_NAME);
        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            path  = String.format("./core/com/%s/%s/core/", Constants.APP_NAME, Constants.MODULE_NAME);
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    private Properties hibernateProperties() {
        var hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.ISOLATION, String.valueOf(Connection.TRANSACTION_REPEATABLE_READ));
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        return hibernateProperties;
    }
}
