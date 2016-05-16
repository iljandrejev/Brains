package com.example.ilja.brains;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by Ilja on 10.04.2016.
 */
public class Calculator {

    private Double num1;
    private Double num2;
    private String operator;


    public Calculator(String[] mathLine){
        num1 = Double.parseDouble(mathLine[0]);
        num2 = Double.parseDouble(mathLine[2]);
        operator = mathLine[1];

    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        Log.d("Brains Calculator","method setNum1");
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        Log.d("Brains Calculator","method setNum2");
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        Log.d("Brains Calculator","method setOperator");
        this.operator = operator;
    }

    public Double getSumma(){
        return num1 + num2;
    }

    public Double getSubstration(){
        return num1 - num2;
    }

    public Double getMultiplication(){
        return num1 * num2;
    }

    public Double getDevision(){
        return num1 / num2;
    }



    public String getResult(){
        switch (operator){
            case "+":
                return getSumma().toString();
            case "-":
                return getSubstration().toString();
            case "×":
                return getMultiplication().toString();
            case "÷":
                if(num2 == 0.0){
                    return "Нельзя делить на ноль";
                }
               return getDevision().toString();
        }
        return "0";
    }
}
