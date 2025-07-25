// To use System generated password we need to block the @EnableWebSecurity
// we need to comment out whole code of  SecurityConfig and UserDetailsservice code. 
package com.pack.techwarehouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Commands needed for base Login
// For base login support, we need to comment out the UserDeatilsService code
/*
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class SecurityConfig 
{	
	// Base login
    @Bean
    public InMemoryUserDetailsManager userDetailsService() 
    {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }
}
*/
//Using Store credentials for login, un comment the UserDetailServiceImpl
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import com.pack.techwarehouse.service.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
private final UserDetailsServiceImpl userDetailsService;
public SecurityConfig(UserDetailsServiceImpl userDetailsService)
{
   this.userDetailsService = userDetailsService;
}
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
{
   auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
}
@Bean
public PasswordEncoder passwordEncoder() 
{
   return new BCryptPasswordEncoder();
}
}




