package com.andresochoahernandez.testonline.configuration;

import com.andresochoahernandez.testonline.model.domain.Domanda;
import com.andresochoahernandez.testonline.model.domain.InTest;
import com.andresochoahernandez.testonline.model.domain.Risposta;
import com.andresochoahernandez.testonline.model.domain.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "domainDatabaseEntityManagerFactory",
        transactionManagerRef   = "domainDatabaseTransactionManager",
        basePackages = {"com.andresochoahernandez.testonline.repository.domain"}
)
public class DomainDatabaseConfiguration {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.domaindatabase")
    public DataSourceProperties domainDatabaseDataSourceProperties(){
        return new DataSourceProperties();
    }
    @Primary
    @Bean
    public DataSource domainDatabaseDataSource(){
        return domainDatabaseDataSourceProperties().initializeDataSourceBuilder().build();
    }
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean domainDatabaseEntityManagerFactory(@Qualifier("domainDatabaseDataSource")DataSource dataSource, EntityManagerFactoryBuilder builder){
        HashMap<String, Object> props = new HashMap<>(); props.put("hibernate.hbm2ddl.auto","update");
        return builder.dataSource(dataSource).packages("com.andresochoahernandez.testonline.model.domain").properties(props).build();
    }
    @Primary
    @Bean
    public PlatformTransactionManager domainDatabaseTransactionManager(@Qualifier("domainDatabaseEntityManagerFactory") LocalContainerEntityManagerFactoryBean domainDatabaseEntityManagerFactory){
        return new JpaTransactionManager(Objects.requireNonNull(domainDatabaseEntityManagerFactory.getObject()));
    }
}
