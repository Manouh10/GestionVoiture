package tech;   
import java.util.ArrayList;
import java.util.List;

 
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * WebConfig
 */
@Configuration
@EnableCaching
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	List<String> exceptions = new ArrayList<>();
    	exceptions.add("/");
    	exceptions.add("/index");
    	exceptions.add("/index.html");

    	exceptions.add("/asserts/**");
    	exceptions.add("/webjars/**");
    	exceptions.add("/css/**");
    	exceptions.add("/js/**");
    	exceptions.add("/img/**");
    	
    	
    	//registry.addInterceptor(new SessionCheckInterceptor()).addPathPatterns("/**").excludePathPatterns(exceptions).excludePathPatterns("/login");
    	
    }

	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("configs");
    }
}