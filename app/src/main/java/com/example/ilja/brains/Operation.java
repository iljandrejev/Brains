package com.example.ilja.brains;

import java.util.Date;

/**
 * Created by Ilja on 16.05.2016.
 */
public class Operation implements IEntity {
    private long id;
    private long operationTypeId;
    private double number1;
    private double number2;
    private double result;

    public Operation(){

    }

    public Operation(String[] mathLine, long operationTypeId, String Result){
        setOperationTypeId(operationTypeId);
        setNumber1(Double.parseDouble(mathLine[0]));
        setNumber2(Double.parseDouble(mathLine[2]));
        setResult(Double.parseDouble(Result));
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
