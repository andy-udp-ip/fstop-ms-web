package tw.com.fstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FstopMsWebApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(FstopMsWebApplication.class, args);
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
