package com.wearegroup11.pabwe;

import com.wearegroup11.pabwe.storage.StorageProperties;
import com.wearegroup11.pabwe.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SistemdinaspertanianApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		/*return super.configure(builder);*/
		return builder.sources(SistemdinaspertanianApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SistemdinaspertanianApplication.class, args);
	}

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //DEFAULT it was called, but I just disabled it
            //storageService.deleteAll();
            storageService.init();
        };
    }
}
