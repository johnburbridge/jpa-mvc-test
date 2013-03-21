package org.metabuild.poc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Profile("integration-test")
@ComponentScan(basePackages = { 
	"org.metabuild.poc.domain",
	"org.metabuild.poc.services"
})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="org.metabuild.poc.repositories")
public class DataTestConfig {


	@Bean(name="hibernateProperties")
	public Properties getHibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.put("hibernate.max_fetch_depth", 3);
		hibernateProperties.put("hibernate.jdbc.fetch_size", 50);
		hibernateProperties.put("hibernate.jdbc.batch_size", 10);
		hibernateProperties.put("hibernate.show_sql", true);
		return hibernateProperties;
	}
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.addScript("classpath:schema.sql")
			.addScript("classpath:test-data.sql")
			.setName("testDb")
			.build();
	}
	

	@Bean(name="entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory(
			@Qualifier(value="dataSource") DataSource dataSource, 
			@Qualifier(value="hibernateProperties") Properties jpaProperties) {
		
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(false); // let hibernate create the database
		
		final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		entityManagerFactory.setPackagesToScan("org.metabuild.poc.domain");
		entityManagerFactory.setJpaProperties(jpaProperties);
		entityManagerFactory.afterPropertiesSet();
		
		return entityManagerFactory.getObject();
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}
	
	@Bean(name="persistenceExceptionTranslator")
	public HibernateExceptionTranslator getPersistExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
}
