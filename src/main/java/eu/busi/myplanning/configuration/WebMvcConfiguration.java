package eu.busi.myplanning.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class register a CORS mapping
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * request max age duration
     */
    private final long MAX_AGE_SECS = 3600;

    /**
     * contains the cors mapping allowed
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("http://192.168.10.172:4201/", "http://localhost:4200", "https://amaury.must.be", "http://amaury.must.be", "https://alapaque.github.io/", "http://alapaque.github.io/")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }
}
