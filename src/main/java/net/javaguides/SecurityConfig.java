import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors() // Enable CORS
            .and()
            .csrf().disable() // Disable CSRF protection for simplicity
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/**").permitAll() // Allow access to API endpoints without authentication
                .anyRequest().authenticated() // All other requests require authentication
            );

        return http.build();
    }
}
