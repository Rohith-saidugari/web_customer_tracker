package com.webcustomertracker.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource myDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //In Memory Authentication
       /* UserBuilder users = User.withDefaultPasswordEncoder();
       auth.inMemoryAuthentication()
              .withUser(users.username("Rohit").password("Test@123").roles("ADMIN"));*/

        // JDBC Authentication
        auth.jdbcAuthentication().dataSource(myDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}
