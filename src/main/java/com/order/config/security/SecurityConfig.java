package com.order.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * security安全配置
 * @author huangbin
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CommonSSIDFilter commonSSIDFilter;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterBefore(authenticationTokenFilterBean(),UsernamePasswordAuthenticationFilter.class);
    }
	
	@Bean
	public CommonSSIDFilter authenticationTokenFilterBean() throws Exception{
		return commonSSIDFilter;
	}
	
	
	
	
	
	
	
}
