package com.example.demo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.secondmongo.dao", mongoTemplateRef = "secondaryMongo")
public class SecondaryMongoConfig {
    @Autowired
    private MongoProperties mongoProperties;

    @Bean(name = "secondaryMongo")
    public MongoTemplate secondaryMongoTemplate() {
        return new MongoTemplate(secoMongoDbFactory(this.mongoProperties));
    }

    @Bean
    public MongoDbFactory secoMongoDbFactory(MongoProperties mongoProperties) {
        ServerAddress serverAddress = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());
        MongoClientOptions mOptions = MongoClientOptions.builder().build();
        MongoCredential mongoCredential;
        MongoClient mongoClient;
        if (mongoProperties.getUsername() != null && mongoProperties.getUsername().length() > 0) {
            mongoCredential = MongoCredential.createCredential(mongoProperties.getUsername(),
                    mongoProperties.getAuthenticationDatabase(), mongoProperties.getPassword());
            mongoClient = new MongoClient(serverAddress, mongoCredential, mOptions);
        } else {
            mongoClient = new MongoClient(serverAddress, mOptions);
        }
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, mongoProperties.getDatabase());
        return mongoDbFactory;
    }
}