package org.example.arango;

import com.arangodb.ArangoDB;
import com.arangodb.Protocol;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories(basePackages = "org.example.arango")
public class ArangoConfig implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder()
                .timeout(100)
                .host("127.0.0.1",8529)
                .user("root")
                .password("1234")
                .useProtocol(Protocol.VST);

    }

    @Override
    public String database() {
        return "MN_Project";
    }
}
