package org.example.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Action {
   private String type;
   private String set;
    private String value;

}
