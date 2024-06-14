package dev.temez.demo.service.user.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerMapperConfiguration {

  @Bean
  Mapper dozerMapper() {
    return DozerBeanMapperBuilder.buildDefault();
  }
}
