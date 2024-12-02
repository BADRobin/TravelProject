package dci.j24e01.TravelBlog.security;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
public class SecurityConfig {
    Dotenv dotenv = Dotenv.load();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        String key = dotenv.get("rememberMeKey");

        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/", "/css/**", "/icons/**", "/fonts/**", "/images/**", "/submit", "/js/**").permitAll();
            auth.requestMatchers("/admin_panel/**").hasRole("ADMIN");
            auth.requestMatchers("/admin").permitAll();
            auth.requestMatchers("admin_panel").authenticated();
            auth.anyRequest().permitAll();
        });

        httpSecurity.formLogin(form -> form
                .loginPage("/admin")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/admin_panel", true)
                .permitAll()
        );

        httpSecurity.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
        );

        httpSecurity.rememberMe(rememberMe -> rememberMe
                .key(key)
                .tokenValiditySeconds(7 * 24 * 60 * 60)
                .tokenRepository(tokenRepository()));

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        String username = dotenv.get("ADMIN_LOGIN");
        String password = dotenv.get("ADMIN_PASSWORD");

        UserDetails admin = User
                .withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public InMemoryTokenRepositoryImpl tokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

}
