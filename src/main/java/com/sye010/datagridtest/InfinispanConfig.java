package com.sye010.datagridtest;

// InfinispanConfig.java
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfinispanConfig {

    @Bean
    public RemoteCacheManager remoteCacheManager() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
                .host("10.10.70.71")
                .port(31836);
        return new RemoteCacheManager(builder.build());
    }
}