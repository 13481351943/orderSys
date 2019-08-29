package com.order.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.common.util.RedisUtil;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	private RedisTemplate<String, Object> redisTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		// 新版序列号
		// 使用Jackson2JsonRedisSerialize 替换默认序列化
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.afterPropertiesSet();
		this.redisTemplate = redisTemplate;
		return redisTemplate;
	}

	@Bean(name = "redisUtil")
	@DependsOn(value = "redisTemplate")
	public RedisUtil redisUtil() {
		RedisUtil redisUtil = new RedisUtil();
		redisUtil.setRedisTemplate(this.redisTemplate);
		return redisUtil;
	}

	
	/**
	 * redis 订阅频道
	 *
	 * @param connectionFactory
	 * @param listenerAdapter
	 * @return
	 */

	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		// 订阅通道，key过期时通知，可以订阅多个通道
		container.addMessageListener(listenerAdapter, new PatternTopic("__keyevent@0__:expired"));

		return container;
	}

	/**
	 * 配置redis事件监听处理器
	 *
	 * @param receiver
	 * @return
	 */
	@Bean
	MessageListenerAdapter listenerAdapter(RedisReceiverMessage receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

}
