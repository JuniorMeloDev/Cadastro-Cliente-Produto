package br.com.api.produtos.config;

/* 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import 
org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;

//Métodos para usar Senha Spring Security

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()  
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
                
              

    }



    //@Bean
   // public PasswordEncoder passwordEncoder() {
  //      return new BCryptPasswordEncoder();
  //  }

}
*/