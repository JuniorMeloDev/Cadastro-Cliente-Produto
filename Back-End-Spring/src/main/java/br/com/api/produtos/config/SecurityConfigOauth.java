package br.com.api.produtos.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Métodos para usar a Autenticação OAuth 2.0 com login Google

@Configuration
@EnableWebSecurity
public class SecurityConfigOauth {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(
            authorizeConfig -> {
              authorizeConfig.antMatchers("/public").permitAll();
              authorizeConfig.antMatchers("/logout").permitAll();
              authorizeConfig.anyRequest().authenticated();
            })
        .oauth2Login(Customizer.withDefaults())
        .build();
  }

}