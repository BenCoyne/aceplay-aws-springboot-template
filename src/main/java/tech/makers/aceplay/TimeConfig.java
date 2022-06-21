package tech.makers.aceplay;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@Configuration
public class TimeConfig {

  @Bean
  Clock clock() {
    return Clock.systemUTC();
  }
}
