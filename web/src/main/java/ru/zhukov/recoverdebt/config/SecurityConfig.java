package ru.zhukov.recoverdebt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().antMatchers("/images/**").permitAll();
        http.authorizeRequests().antMatchers("/resources/**").permitAll();
        /*http.logout().logoutUrl("/logout")
                 .logoutSuccessUrl("/login")
                 .invalidateHttpSession(true)
                 .clearAuthentication(true)
                 .deleteCookies("JSESSIONID")
                 .and();*/
        http.authorizeRequests()

                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/",false)
                .permitAll()
                .and()


        ;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("1").roles("USER")
                .and()
                .withUser("admin").password("2").roles("USER", "ADMIN");
    }
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("1").roles("ADMIN").and()
                .withUser("user").password("demo").roles("USER").and()               ;
    }*/


}
