package net.codejava.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
     
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/Welcome_Page").authenticated()
            .antMatchers("/UpdatePassword").authenticated()
            .antMatchers("/UpdatePassword/save").authenticated()
            .antMatchers("/RuserProfile").authenticated()
            .antMatchers("/RuserProfile/new").authenticated()
            .antMatchers("/RuserProfile/edit/{id}").authenticated()
            .antMatchers("/RuserProfile/delete/{id}").authenticated()
            .antMatchers("/Rcurrency").authenticated()
            .antMatchers("/Rcurrency/new").authenticated()
            .antMatchers("/Rcurrency/edit/{id}").authenticated()
            .antMatchers("/Rcurrency/delete/{id}").authenticated()
            .antMatchers("/Ruser").authenticated()
            .antMatchers("/Ruser/new").authenticated()
            .antMatchers("/Ruser/edit/{id}").authenticated()
            .antMatchers("/Ruser/delete/{id}").authenticated()
            .antMatchers("/Clistsys").authenticated()
            .antMatchers("/Clistsys/new").authenticated()
            .antMatchers("/Clistsys/edit/{id}").authenticated()
            .antMatchers("/Clistsys/delete/{id}").authenticated()//
            .antMatchers("/Clistcust").authenticated()
            .antMatchers("/Clistcust/new").authenticated()
            .antMatchers("/Clistcust/edit/{id}").authenticated()
            .antMatchers("/Clistcust/delete/{id}").authenticated()//
            .antMatchers("/CpnlSetting").authenticated()
            .antMatchers("/CpnlSetting/new").authenticated()
            .antMatchers("/CpnlSetting/edit/{id}").authenticated()
            .antMatchers("/CpnlSetting/delete/{id}").authenticated()//
            .antMatchers("/CpnlSettingDetail").authenticated()
            .antMatchers("/CpnlSettingDetail/new").authenticated()
            .antMatchers("/CpnlSettingDetail/edit/{id}").authenticated()
            .antMatchers("/CpnlSettingDetail/delete/{id}").authenticated()//
            .antMatchers("/Ccurve").authenticated()
            .antMatchers("/Ccurve/new").authenticated()
            .antMatchers("/Ccurve/edit/{id}").authenticated()
            .antMatchers("/Ccurve/delete/{id}").authenticated()//
            .antMatchers("/CinputControl").authenticated()
            .antMatchers("/CinputControl/new").authenticated()
            .antMatchers("/CinputControl/edit/{id}").authenticated()
            .antMatchers("/CinputControl/delete/{id}").authenticated()//
            .antMatchers("/header").authenticated()//
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
                .usernameParameter("uCode")
                .defaultSuccessUrl("/Welcome_Page")
                .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
    		.clearAuthentication(true)
    		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    		.logoutSuccessUrl("/login")
    		.permitAll();
    }
     
     
}
