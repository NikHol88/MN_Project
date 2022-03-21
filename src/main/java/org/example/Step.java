package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Step {
   private int stepId;
  private   Action action;
private String parseWith;
private String returnType;


}
