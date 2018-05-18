package ch.gemdat.romanNumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

@SpringBootApplication
public class RomanNumberApplication extends DelegatingWebMvcConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(RomanNumberApplication.class, args);
	}

	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	    configurer.enable();
	}

}