package com.backend.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = {"com.backend.domain.model.repository"})
@Import(InfrastructureConfig.class)
public class ApplicationConfig {
}