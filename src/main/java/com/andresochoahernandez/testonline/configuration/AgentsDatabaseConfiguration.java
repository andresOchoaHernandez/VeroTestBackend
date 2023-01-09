package com.andresochoahernandez.testonline.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "agentsDatabaseEntityManagerFactory",
        transactionManagerRef   = "agentsDatabaseTransactionManager",
        basePackages = {"com.andresochoahernandez.testonline.repository.agents"}
)
public class AgentsDatabaseConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.agentsdatabase")
    public DataSourceProperties agentsDataSourceProperties(){
        return new DataSourceProperties();
    }
    @Bean
    public DataSource agentsDatabaseDataSource(){
        return agentsDataSourceProperties().initializeDataSourceBuilder().build();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean agentsDatabaseEntityManagerFactory(@Qualifier("agentsDatabaseDataSource")DataSource dataSource, EntityManagerFactoryBuilder builder){
        HashMap<String, Object> props = new HashMap<>(); props.put("hibernate.hbm2ddl.auto","update");
        return builder.dataSource(dataSource).packages("com.andresochoahernandez.testonline.model.agents").properties(props).build();
    }
    @Bean
    public PlatformTransactionManager agentsDatabaseTransactionManager(@Qualifier("agentsDatabaseEntityManagerFactory") LocalContainerEntityManagerFactoryBean agentsDatabaseEntityManagerFactory){
        return new JpaTransactionManager(Objects.requireNonNull(agentsDatabaseEntityManagerFactory.getObject()));
    }
}
