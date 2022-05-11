package org.example.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Action {
   private ActionType type;
   private String set;
    private String value;

}
