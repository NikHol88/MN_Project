package org.example.arango;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import org.example.model.ParserSteps;
import org.example.repository.ArangoRepositiry;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveRepository extends ArangoRepository<ParserSteps,String> {
    @Query("INSERT @ParserSteps INTO StepConfig")
    public void saveConfig(ParserSteps parserSteps);


}
