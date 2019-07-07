package com.herokapp.traininfomation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.herokapp.traininfomation.service.TokyoMetroTrainInfomationServiceImpl;
import com.herokapp.traininfomation.service.TrainInfomationService;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public TrainInfomationService getTokyoMetroTrainInfomationService() {
		return new TokyoMetroTrainInfomationServiceImpl();
	}

}
