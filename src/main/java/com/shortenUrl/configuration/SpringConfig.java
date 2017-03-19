package com.shortenUrl.configuration;

import com.shortenUrl.common.Defines;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@EnableJpaRepositories(basePackages = Defines.Packages.REPOISTORY_PACKAGE)
@EnableTransactionManagement
@ComponentScan(basePackages = Defines.Packages.BASE_PACKAGE)
@PropertySource(name = Defines.Statics.APPLICATION_PROPERTIES,
        value = {Defines.Statics.PROP_FILE_PATH},
            ignoreResourceNotFound = false)

public class SpringConfig extends WebMvcConfigurerAdapter {

   
    @Autowired
    private ConfigurableEnvironment env;


    @Bean()
    public DataSource dataSource() {

        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(Defines.DataSource.DB_DRIVER_CLASS));
        dataSource.setUrl(env.getProperty(Defines.DataSource.DB_URL));
        dataSource.setUsername(env.getProperty(Defines.DataSource.DB_USERNAME));
        dataSource.setPassword(env.getProperty(Defines.DataSource.DB_PASSWORD));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(Defines.Packages.MODEL_PACKAGE);
        em.setJpaProperties(this.additionalProperties());
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty(Defines.Hibernate.DIALECT, env.getProperty(Defines.Hibernate.DIALECT));
        properties.setProperty(Defines.Hibernate.CONN_POOL_SIZE, env.getProperty(Defines.Hibernate.CONN_POOL_SIZE));
        properties.setProperty(Defines.Hibernate.SHOW_SQL, env.getProperty(Defines.Hibernate.SHOW_SQL));
        properties.setProperty(Defines.Hibernate.HBM2DDL_AUTO, env.getProperty(Defines.Hibernate.HBM2DDL_AUTO));
        properties.setProperty(Defines.Hibernate.SESSION_CONTEX_CLASS, env.getProperty(Defines.Hibernate.SESSION_CONTEX_CLASS));

        return properties;
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(env.getProperty(Defines.ViewResolver.PREFIX));
        viewResolver.setSuffix(env.getProperty(Defines.ViewResolver.SUFIX));
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Static ressources from both WEB-INF 
        registry
                .addResourceHandler(env.getProperty(Defines.ResourceHandler.RESOURCE_HANDLER))
                .addResourceLocations(env.getProperty(Defines.ResourceHandler.RESOURCE_LOCATIONS))
                .setCachePeriod(  Integer.parseInt(  env.getProperty(Defines.ResourceHandler.RESOURCES_CACHE_PERIOD) ) );

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    
}
