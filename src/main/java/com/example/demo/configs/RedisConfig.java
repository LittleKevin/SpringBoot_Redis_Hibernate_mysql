package com.example.demo.configs;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching

public class RedisConfig {
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {
		RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig();
		//生成一个默认配置
		config=config.entryTtl(Duration.ofMinutes(1))
				//设置缓存默认过期时间
				.disableCachingNullValues();
		//不缓存空值
		
		//设置一个初始化的缓存空间set集合
		Set<String> cacheNames=new HashSet<>();
		cacheNames.add("my-redis-cache1");
		cacheNames.add("my-redis-cache2");
		
		//对每个缓存空间应用不同的配置
		Map<String,RedisCacheConfiguration> configMap=new HashMap<>();
		configMap.put("my-redis-cache1", config);
		configMap.put("my-redis-cache2", config.entryTtl(Duration.ofSeconds(120)));
		
		RedisCacheManager cacheManager=RedisCacheManager.builder(factory)
				.initialCacheNames(cacheNames)
				.withInitialCacheConfigurations(configMap)
				.build();
		return cacheManager;
		}
		
		/**
		 * 自定义redis序列化器
		 */
		@Bean
		   public RedisTemplate<Object,Object> billredisTemplate(RedisConnectionFactory redisConnectionFactory){
		      RedisTemplate<Object,Object> templateFor = new RedisTemplate<Object,Object>();
		      templateFor.setConnectionFactory(redisConnectionFactory);
		      Jackson2JsonRedisSerializer<Object> ser = new Jackson2JsonRedisSerializer<Object>(Object.class);
		     templateFor.setValueSerializer(ser);
		     templateFor.setKeySerializer(new StringRedisSerializer());
		     templateFor.setHashKeySerializer(ser);	 
		     templateFor.setDefaultSerializer(ser);
		     templateFor.setEnableDefaultSerializer(true);
		     templateFor.afterPropertiesSet();
		      return templateFor;
		   }
	
}