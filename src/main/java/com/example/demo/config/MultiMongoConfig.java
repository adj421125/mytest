package com.example.demo.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultiMongoConfig {
    @Bean(name = "PrimaryMongoDataSourceConfig")
    @Primary
    @ConfigurationProperties(prefix = "mongo")
    public MongoProperties parmaryMongoProperties() {
        return new MongoProperties();
    }

    @Bean(name = "SecondaryMongoDataSourceConfig")
    @ConfigurationProperties(prefix = "secondmongo")
    public MongoProperties secondaryMongoProperties() {
        return new MongoProperties();
    }
}