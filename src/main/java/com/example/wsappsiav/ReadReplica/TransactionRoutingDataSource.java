package com.example.wsappsiav.ReadReplica;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class TransactionRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getEnvironment();
    }
}
