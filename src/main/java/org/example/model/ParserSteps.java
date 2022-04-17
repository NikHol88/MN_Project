package org.example.model;

import lombok.Data;

import java.util.List;
@Data
public class ParserSteps {
    List<Step> steps;
    String uid;
    String name;
}
