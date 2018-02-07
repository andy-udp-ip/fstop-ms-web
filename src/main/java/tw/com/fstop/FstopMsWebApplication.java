package tw.com.fstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * For deploy to application server and running in stand alone mode,
 * first the application entry class should extend SpringBootServletInitializer,
 * second the application entry class should override "configure" method of SpringBootServletInitializer, 
 * third has the public static "main" method. 
 *  
 * 
 *
 * @since 1.0.1
 */
@SpringBootApplication
//public class FstopMsWebApplication
public class FstopMsWebApplication extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(FstopMsWebApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
    {
        return application.sources(FstopMsWebApplication.class);
    }    

    /**
     * 宣告並產生一個 RestTemplate bean，以方便使用注入的方式.
     * RestTemplate 使用 RestTemplateBuilder 來建構，
     * 由 spring boot 進行 auto-config
     * @param builder - spring boot will inject RestTemplateBuilder
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }
}
