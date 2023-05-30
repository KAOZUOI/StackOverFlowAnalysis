package com.redis.connection;import javax.annotation.Resource;import com.secretsmanagement.api.CredentialProvider;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.data.redis.RedisConnectionFailureException;import org.springframework.data.redis.connection.RedisStandaloneConfiguration;import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;import org.springframework.data.redis.core.RedisTemplate;import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;import org.springframework.data.redis.serializer.GenericToStringSerializer;