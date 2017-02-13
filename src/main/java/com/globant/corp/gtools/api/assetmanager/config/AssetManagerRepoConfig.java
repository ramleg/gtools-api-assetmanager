package com.globant.corp.gtools.api.assetmanager.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Ram
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.globant.corp.gtools.api.assetmanager.repo", entityManagerFactoryRef = "assetManagerEntityManagerFactory", transactionManagerRef = "assetManagerTransactionManager")
@EnableTransactionManagement
@PropertySource("classpath:assetmanager-datasource.properties")
public class AssetManagerRepoConfig {
    
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "assetmanager.datasource")
    public DataSource assetManagerDataSource()
    {
      return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean assetManagerEntityManagerFactory(final EntityManagerFactoryBuilder builder)
    {
      return builder
          .dataSource(assetManagerDataSource())
          .packages("com.globant.corp.gtools.api.assetmanager.entity")
          .persistenceUnit("assetManagerPersistenceUnit")
          .build();
    }

    @Bean
    @Primary
    public JpaTransactionManager assetManagerTransactionManager(@Qualifier("assetManagerEntityManagerFactory") final EntityManagerFactory factory)
    {
      return new JpaTransactionManager(factory);
    }
    
}
