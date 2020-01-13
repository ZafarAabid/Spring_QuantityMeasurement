package com.quantitymeasurement.model;

public class ParameterBody {

    String unit1;
    Double val1;
    String unit2;
    Double val2;

    public ParameterBody(String unit1, Double val1, String unit2, Double val2){
        this.unit1 = unit1;
        this.val1 = val1;
        this.unit2 = unit2;
        this.val2 = val2;
    }

    public String getUnit1() {
        return unit1;
    }

    public Double getVal1() {
        return val1;
    }

    public String getUnit2() {
        return unit2;
    }

    public Double getVal2() {
        return val2;
    }
}
