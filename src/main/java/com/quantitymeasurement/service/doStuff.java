package com.quantitymeasurement.service;

import com.quantitymeasurement.model.IUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class doStuff {

    IUnit unitFirst, unitSecond;

    @Autowired
    UnitContainer unitContainer;
    @Autowired
    QuantityMeasurement quantityMeasurement;

    public String doCompare(String unit1, Double val1, String unit2, Double val2) {
        try {
            unitFirst = unitContainer.getUnit(unit1);
            unitSecond = unitContainer.getUnit(unit2);
            boolean compare = quantityMeasurement.compare(unitFirst, val1, unitSecond, val2);
            return val1 + unit1 + " is equal to " + val2 + unit2 + compare;
        } catch (QuantityMeasurementException e) {
            return "something Went wrong....." + "<br><br>" + e.getMessage();
        }
    }


    public String doAdd(String unit1, Double val1, String unit2, Double val2) {
        try {
            unitFirst = unitContainer.getUnit(unit1);
            unitSecond = unitContainer.getUnit(unit2);
            Double additionOfTwoUnits = quantityMeasurement.additionOfTwoUnits(unitFirst, val1, unitSecond, val2);
            return "Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to " + additionOfTwoUnits;
        } catch (QuantityMeasurementException e) {
            return "something Went wrong....." + "<br><br>" + e.getMessage();
        }
    }
}
