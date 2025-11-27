package com.cps.collegePlacementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.web.servlet.function.RequestPredicates.headers;

@Configuration
    @EnableWebSecurity
    @Component
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF for H2 console
                    .authorizeHttpRequests(authz -> authz.anyRequest().permitAll())

//                    .authorizeHttpRequests((authz) -> authz
//                            .requestMatchers("/h2-console/**","/api/students/**").permitAll()  // Public access for signup and login
//                            .anyRequest().authenticated()                      // Restrict access to all other pages
//                    )


                    .headers((headers) -> headers
                            .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)  // New syntax to disable frameOptions
                    ); // Disable frame options for H2

//            http.addFilterBefore(new CsrfLoggingFilter(), SecurityContextHolderAwareRequestFilter.class);


            return http.build();
        }



        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }


