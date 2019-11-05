package br.com.radiflix;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@ComponentScan({ 
	"br.com.radiflix.controller", 
	"br.com.radiflix.service" 
})
public class RadiflixApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(RadiflixApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public Queue myQueue() {
	    return new Queue("myQueue", false);
	}
}
