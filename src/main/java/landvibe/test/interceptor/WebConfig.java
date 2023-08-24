/*
package landvibe.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private final SessionCheckInterceptor sessionAop;

    public WebConfig(SessionCheckInterceptor sessionAop) {
        this.sessionAop = sessionAop;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionAop);
    }

}
*/
