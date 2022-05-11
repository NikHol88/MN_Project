package org.example.service;


import lombok.Data;
import org.example.arango.SaveRepository;
import org.example.model.ParserSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConfigSaveService {
private SaveRepository saveRepository;
@Autowired
    public ConfigSaveService(SaveRepository saveRepository) {
        this.saveRepository = saveRepository;
    }
    public void saveConfig(ParserSteps parserSteps){
    saveRepository.saveConfig(parserSteps);
    }
    public List<ParserSteps> readConfig(){

   return saveRepository.readConfig(); }
    public ParserSteps readForNameConfig(String name){

        return saveRepository.readForNameConfig(name); }
    public List<ParserSteps> reloadConfigFromDB(){
    return saveRepository.readConfig();
    }
}
