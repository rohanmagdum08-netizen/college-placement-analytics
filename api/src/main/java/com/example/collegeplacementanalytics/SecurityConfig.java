package com.example.collegeplacementanalytics;
import org.springframework.context.annotation.*;import org.springframework.security.config.Customizer;import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;import org.springframework.security.config.annotation.web.builders.HttpSecurity;import org.springframework.security.core.userdetails.*;import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.security.provisioning.InMemoryUserDetailsManager;import org.springframework.security.web.SecurityFilterChain;
@Configuration @EnableMethodSecurity public class SecurityConfig{
 @Bean SecurityFilterChain chain(HttpSecurity h)throws Exception{h.csrf(c->c.disable()).authorizeHttpRequests(a->a.requestMatchers("/","/index.html","/favicon.ico","/error","/h2-console/**").permitAll().anyRequest().authenticated()).httpBasic(Customizer.withDefaults());h.headers(x->x.frameOptions(f->f.sameOrigin()));return h.build();}
 @Bean UserDetailsService users(PasswordEncoder e){return new InMemoryUserDetailsManager(User.withUsername("admin").password(e.encode("admin123")).roles("ADMIN").build(),User.withUsername("demo").password(e.encode("demo123")).roles("USER").build());}
 @Bean PasswordEncoder encoder(){return new BCryptPasswordEncoder();}
}
