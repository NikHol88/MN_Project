package org.example.arango;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import org.example.model.ParserSteps;
import org.example.model.User;
import org.example.repository.ArangoRepositiry;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaveRepository extends ArangoRepository<ParserSteps,String> {
    @Query("INSERT @parserSteps INTO StepConfig")
    public void saveConfig(ParserSteps parserSteps);

    @Query("FOR existed IN StepConfig return existed")
    public List<ParserSteps> readConfig();

    @Query("FOR existed IN StepConfig " +
            "FILTER existed.name==@name "+
            "return existed")

    public ParserSteps readForNameConfig(String name);

    @Query("FOR existed IN User " +
            "FILTER existed.name==@name"+
            "return existed")
    public User readUserForName(String name);
}
