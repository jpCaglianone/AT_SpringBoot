//package com.example.at_springboot.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class ConfigSecurity {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .dispatcherTypeMatchers(HttpMethod.valueOf("/public/**")).permitAll()
//                .anyRequest().authenticated();
//
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var user = User.withUsername("meuusuario")
//                .password("minhasenha")
//                .roles("USER")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user);
//    }
//}
