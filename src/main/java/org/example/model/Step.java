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
    private  Boolean saveResult;
    private int useResultForStep;


    public Integer useResult(int i) throws ResultErrorException {

            if (i < stepId) {
                return i;
            }
            if (i>=stepId) throw  new ResultErrorException("No Result");//???


                System.out.println("Error StepResult");



        return -1;
    }}
