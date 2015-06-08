package com.htds.spring.samples.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * Created by Hasan
 * on 8.6.2015.
 */
@Configuration
@EnableJpaRepositories("com.htds.spring.samples.repository.")
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware {

	private Environment env;
	private RelaxedPropertyResolver dataSourcePropertyResolver;

	@Override
	public void setEnvironment(Environment env) {
		this.dataSourcePropertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
	}

	@Bean(destroyMethod = "shutdown")
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDataSourceClassName(dataSourcePropertyResolver.getProperty("dataSourceClassName"));
		if(StringUtils.isEmpty(dataSourcePropertyResolver.getProperty("url"))) {
			config.addDataSourceProperty("databaseName", dataSourcePropertyResolver.getProperty("databaseName"));
			config.addDataSourceProperty("serverName", dataSourcePropertyResolver.getProperty("serverName"));
		} else {
			config.addDataSourceProperty("url", dataSourcePropertyResolver.getProperty("url"));
		}
		config.addDataSourceProperty("user", dataSourcePropertyResolver.getProperty("username"));
		config.addDataSourceProperty("password", dataSourcePropertyResolver.getProperty("password"));

		return new HikariDataSource(config);
	}
}
