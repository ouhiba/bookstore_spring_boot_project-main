package com.bookStore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Configuration de l'authentification
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() // Configuration d'un utilisateur en mémoire (utilisation pour le développement)
                .withUser("user").password("{noop}password").roles("USER"); // Utilisateur avec nom d'utilisateur "user", mot de passe "password" et rôle "USER"
    }

    // Configuration des autorisations
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // Début de la configuration des autorisations
                .antMatchers("/public/**").permitAll() // Autoriser l'accès aux URL commençant par "/public" sans authentification
                .anyRequest().authenticated() // Toutes les autres URL nécessitent une authentification
                .and()
                .formLogin(); // Utilisation du formulaire de connexion par défaut de Spring Security
    }
}
