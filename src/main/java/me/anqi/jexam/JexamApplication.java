package me.anqi.jexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableCaching
public class JexamApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JexamApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JexamApplication.class, args);
	}
}
