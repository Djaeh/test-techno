package com.example.demo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;

@SpringBootApplication
public class DemoApplication {

	@Bean
	MongoDbFactory mongoDbFactory(MongoClient mongo) {
		return new TenantMongoDbFactory(mongo, "bookStore");
	}

	@Bean
	public MongoClient mongo(MongoProperties properties, ObjectProvider<MongoClientOptions> options, Environment environment) {
		return (new MongoClientFactory(properties, environment)).createMongoClient((MongoClientOptions) options.getIfAvailable());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
