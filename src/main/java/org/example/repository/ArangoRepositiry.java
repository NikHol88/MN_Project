package org.example.repository;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.Protocol;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.mapping.ArangoJack;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
//@Component
public class ArangoRepositiry {
    ArangoDB arangoDB;
@Autowired
    public ArangoRepositiry(ArangoDB arangoDB) {
        this.arangoDB = arangoDB;
    }


}
