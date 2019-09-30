package com.wretchant.csdnchart.configuration;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@ConfigurationProperties("spring.execute")
@EnableAsync
@Configuration
@Setter
public class ThreadConfiguration {

  private int corePoolSize;
  private int maxPoolSize;
  private int queueCapacity;

  @Bean
  Executor executor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    return executor;
  }
}
