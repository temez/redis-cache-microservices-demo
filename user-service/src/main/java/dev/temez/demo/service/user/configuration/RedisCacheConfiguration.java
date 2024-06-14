package dev.temez.demo.service.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisCacheConfiguration {

  @Bean
  @Primary
  org.springframework.data.redis.cache.RedisCacheConfiguration redisCacheInternalConfiguration() {
    return org.springframework.data.redis.cache.RedisCacheConfiguration
        .defaultCacheConfig()
        .disableCachingNullValues()
        .entryTtl(Duration.ofMinutes(60))
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }
}
