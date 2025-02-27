package com.JavaSpringBoot.MyProject.Config;

import com.JavaSpringBoot.MyProject.Repositories.UserRepository;
import com.JavaSpringBoot.MyProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

    @Autowired
    private UserRepository userRepository;

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests((request)->request
                    .requestMatchers("/home","/registration","/login")
                    .permitAll()// Разрешить доступ к /home,/registration и /login всем
                    .anyRequest()
                    .authenticated())// Все остальные запросы требуют аутентификации
            .formLogin((form)->form
                    .loginPage("/login")// Указать страницу входа
                    .permitAll()// Разрешить доступ к странице входа всем
                    .defaultSuccessUrl("/home"))// Указать страницу для перенаправления после успешного входа
            .logout(LogoutConfigurer::permitAll);// Разрешить доступ к выходу всем
    return http.build();
}
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService(userRepository, bCryptPasswordEncoder());
    }
    @Bean
    public DaoAuthenticationProvider authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(5);
    }
}