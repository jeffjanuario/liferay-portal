package com.api.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvertClassModelConfig<T, E> {
	
	@Bean
	public ConvertClassModelConfig<T, E> convertClassModel() {
		return new ConvertClassModelConfig<T, E>();
	}
	
}
