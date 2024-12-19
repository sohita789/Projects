package com.xworkz.xworkz_CommonModule_Sohita.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.xworkz_CommonModule_Sohita")
@EnableWebMvc
@Slf4j
public class ModuleConfiguration {
	
	ModuleConfiguration(){;
	System.out.println("created the noArgs Module");
 }
	@Bean
    public LocalContainerEntityManagerFactoryBean localcontainerEntityManagerBean() {
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    log.info("This is a Common_Module_sohita project");
    bean.setPackagesToScan("com.xworkz.xworkz_CommonModule_Sohita.entity");
    bean.setDataSource(dataSource());
    bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    return bean;
    	
    }
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/xworkz_login");
    	dataSource.setUsername("root");
    	dataSource.setPassword("xworkzodc");
    	return dataSource;
    	
    }

}
