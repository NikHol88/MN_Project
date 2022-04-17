package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Step {
   private int stepId;
  private   Action action;
  //enum
private  ParseWith parseWith;
private String returnType;


}
