package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Steps {
   private int stepId;
  private   Action action;
private String parseWith;
private String returnType;

   /* public Steps(int stepId, Action action, String parseWith, String returnType) {
        System.out.println("Con"+stepId);
        this.stepId = stepId;
        this.action = action;
        this.parseWith = parseWith;
        this.returnType = returnType;
    }

    public Steps() {

    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        System.out.println("Sett"+stepId);
        this.stepId = stepId;

    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getParseWith() {
        return parseWith;
    }

    public void setParseWith(String parseWith) {
        this.parseWith = parseWith;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }*/
}
