package com.spring.jdbc.tutorial.SpringJDBCSimpleExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.tutorial.SpringJDBCSimpleExample"})
public class JDBCConfig {

	
	@Bean("dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/userManagement");
		ds.setUsername("root");
		ds.setPassword("password");
		
		
		return ds;
	}
	
	
	@Bean("jdbcTempalate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jd = new JdbcTemplate();
		jd.setDataSource(getDataSource());
		return jd;
	}
	
	
}
