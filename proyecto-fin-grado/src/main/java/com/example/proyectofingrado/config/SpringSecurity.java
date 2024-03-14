package com.example.proyectofingrado.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // filtro de seguridad
    //http://localhost:8080/register?continue

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        return http.build();

      /**  DESCOMENTAR ESTO Y BORRAR LO DE ARRIBA PARA ACTIVAR LA SPRING SECURITY
       * http.authorizeRequests()//comienza autorizacion para solicitudes hhtp
                .requestMatchers("/registro/**").permitAll() //todo el mundo tiene acceso a los endpoints de registro + algo
                .requestMatchers("/index").permitAll() //todos los usuarios tienen acceso al índice
                .requestMatchers("/users").hasRole("ADMIN") //solo los administradores pueden ver los usuarios
                .requestMatchers("/menu").permitAll()
                .requestMatchers("/pacientes/**").permitAll()
                .and()
                .formLogin( //autenticacion del formulario
                        form -> form
                                .loginPage("/login") //pagina de login
                                .loginProcessingUrl("/login") //pagina que se muestra al procesar el login
                                .defaultSuccessUrl("/menu") //pagina al hacer un buen login
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
**/
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}
