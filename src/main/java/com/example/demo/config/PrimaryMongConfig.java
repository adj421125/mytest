package com.example.demo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.mongo.dao", mongoTemplateRef = "parmaryMongo")
public class PrimaryMongConfig {

    @Autowired
    // @Qualifier("PrimaryMongoDataSourceConfig")
    private MongoProperties mongoProperties;

    @Primary
    @Bean(name = "primaryMongo")
    public MongoTemplate parimaryMongoTemplate() {
        return new MongoTemplate(primarFactory(this.mongoProperties));
    }

    @Bean
    @Primary
    public MongoDbFactory primarFactory(MongoProperties mongoProperties) {
        ServerAddress serverAddress = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());
        MongoClientOptions options = MongoClientOptions.builder().build();
        MongoCredential credential;
        MongoClient mongoClient;
        if (mongoProperties.getUsername() != null && mongoProperties.getUsername().length() > 0) {
            credential = MongoCredential.createCredential(mongoProperties.getUsername(),
                    mongoProperties.getAuthenticationDatabase(), mongoProperties.getPassword());
            mongoClient = new MongoClient(serverAddress, credential, options);
        } else {
            mongoClient = new MongoClient(serverAddress, options);
        }
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, mongoProperties.getDatabase());
        return mongoDbFactory;
    }
}