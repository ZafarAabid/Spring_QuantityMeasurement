package com.quantitymeasurement;

import com.quantitymeasurement.model.IUnit;
import com.quantitymeasurement.model.ParameterBody;
import com.quantitymeasurement.service.ConvertStringParameterIntoEnum;
import com.quantitymeasurement.service.QuantityMeasurement;
import com.quantitymeasurement.service.UnitContainer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuantityMeasurementApplicationTests {
    private String unit2;
    private Double val1;
    private String unit1;
    private Double val2;
    private ParameterBody parameterBody;

    @Mock
    ConvertStringParameterIntoEnum stringParameterIntoEnum;
    @InjectMocks
    QuantityMeasurementController quantityMeasurementController;

    @BeforeEach
    void setUp() {
         unit2="CENTI_METER";
         val1= 2.0;
         unit1="CENTI_METER";
         val2=2.0;
         parameterBody = new ParameterBody(unit1,val1,unit2,val2);

    }

    @Test
    void givenTwoSameUnits_WhenPassedFromControllerToCompare_ShouldReturnTrueStatement() {
        when(stringParameterIntoEnum.doCompare(unit1,val1,unit2,val2)).thenReturn("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : true");
        String compareUnits = quantityMeasurementController.compareUnits(unit1, val1, unit2, val2);
        Assert.assertEquals("is 2.0CENTI_METER equal to 2.0CENTI_METER? : true",compareUnits);
    }

    @Test
    void givenTwoDifferentUnits_WhenPassedFromControllerToCompare_ShouldReturnFalseStatement() {
        unit1="CENTI_METER";
        val1=2.0;
        unit2="YARD";
        val2=2.0;
        when(stringParameterIntoEnum.doCompare(unit1,val1,unit2,val2)).thenReturn("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : false");
        String compareUnits = quantityMeasurementController.compareUnits(unit1, val1, unit2, val2);
        Assert.assertEquals("is 2.0CENTI_METER equal to 2.0YARD? : false",compareUnits);
    }

    @Test
    void givenTwoUnits_WhenPassedFromControllerToAdd_ShouldReturnAddition() {
        unit1="CENTI_METER";
        val1=2.0;
        unit2="CENTI_METER";
        val2=2.0;
        when(stringParameterIntoEnum.doAdd(unit1,val1,unit2,val2)).thenReturn("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0);
        String compareUnits = quantityMeasurementController.addUnits(unit1, val1, unit2, val2);
        Assert.assertEquals("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0,compareUnits);
    }

    @Test
    void givenBodyOfParam_WhenPassedFromControllerToAdd_ShouldReturnAddition() {
        when(stringParameterIntoEnum.doAddByBody(parameterBody)).thenReturn("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0);
        String compareUnits = quantityMeasurementController.addUnits(parameterBody);
        Assert.assertEquals("Addition of " + val1 + unit1 + " & " + val2 + unit2 + " is equal to "+4.0,compareUnits);
    }

    @Test
    void givenBodyOfParam_WhenPassedFromControllerToCompare_ShouldReturn() {
        when(stringParameterIntoEnum.doCompareByBody(parameterBody)).thenReturn("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : true");
        String compareUnits = quantityMeasurementController.compareUnits(parameterBody);
        Assert.assertEquals("is "+val1 + unit1 + " equal to " + val2 + unit2 +"? : true",compareUnits);
    }



}
