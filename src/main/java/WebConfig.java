import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applies to all endpoints
                .allowedOrigins("http://44.203.120.219:3000") // Specify your frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify HTTP methods
                .allowCredentials(true); // If you need credentials
    }
}
