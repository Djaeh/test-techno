package com.example.demo;

import com.example.demo.entity.TenantContext;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

public class TenantMongoDbFactory extends SimpleMongoDbFactory {
    public TenantMongoDbFactory(MongoClient mongoClient, String databaseName) {
        super(mongoClient, databaseName);
    }

    @Override
    public MongoDatabase getDb(String dbName) throws DataAccessException {
        return super.getDb(TenantContext.getCurrentTenant() + "_" + dbName);
    }
}
