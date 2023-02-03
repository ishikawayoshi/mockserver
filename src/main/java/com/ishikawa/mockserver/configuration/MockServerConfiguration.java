package com.ishikawa.mockserver.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ishikawa.mockserver.services"})
public class MockServerConfiguration {
}
