package br.com.joaolevada.todolist.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter(), WebMvcConfigurer {

    override fun configure(http:HttpSecurity) {

        // public endpoints
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/openapi").permitAll()
                .antMatchers(HttpMethod.POST, "/openapi").permitAll()
                .antMatchers(HttpMethod.DELETE, "/openapi").permitAll()
                .antMatchers(HttpMethod.PUT, "/openapi").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()

        http.cors().and().csrf().disable()
    }
}