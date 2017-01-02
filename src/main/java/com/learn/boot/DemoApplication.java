package com.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import db.migration.DatabaseMigrator;


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.learn"})
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class, HibernateJpaAutoConfiguration.class,DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@ContextConfiguration (classes = {PersistenceContext.class})
public class DemoApplication {
    private static Class<DemoApplication> entryPointClass = DemoApplication.class;


	public static void main(String[] args) {
	    if("migration".equalsIgnoreCase(System.getProperty("runtype"))){
            DatabaseMigrator.main(args);
            return;
        }
		SpringApplication.run(entryPointClass, args);
	}

}
