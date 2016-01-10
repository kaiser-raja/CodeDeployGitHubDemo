package com.backend.application.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableWebMvc
//@EnableJpaRepositories
public class InfrastructureConfig {
	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.backend.domain.model", "com.backend.infrastructure.persistence", "com.backend.interfaces.facade.*", "com.backend.application.service.*" } );
	      //em.setPackagesToScan(new String[] { "com.backend" } );
	      em.setPersistenceUnitName("homecooked");
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	      //em.afterPropertiesSet();

	      return em;
	   }
	 
	   @Bean
	   public DataSource dataSource(){
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://10.164.2.5:3306/homecooked");
	      dataSource.setUsername( "root" );
	      dataSource.setPassword( "root" );
	      Properties properties = new Properties();
	      properties.setProperty("processEscapes", "true");
	      dataSource.setConnectionProperties(properties);
	      return dataSource;
	   }
	 
	   @Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	   
	   @Bean
	   public EntityManager entityManager() {
		   	EntityManager manager = entityManagerFactory().getObject().createEntityManager();
		    return manager;
		} 
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", "validate");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	      properties.setProperty("hibernate.show_sql", "true");
	      properties.setProperty("hibernate.format_sql", "true");
	      return properties;
	   }
	   
	   
	   @Bean
	   public DispatcherServlet dispatcherServlet() {
	       return new DispatcherServlet();
	   }

	   /**
	    * Register dispatcherServlet programmatically 
	    * 
	    * @return ServletRegistrationBean
	    */
	   @Bean
	   public ServletRegistrationBean dispatcherServletRegistration() {

	       ServletRegistrationBean registration = new ServletRegistrationBean(
	               dispatcherServlet(), "/*");

	       registration
	               .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

	       return registration;
	   }
}