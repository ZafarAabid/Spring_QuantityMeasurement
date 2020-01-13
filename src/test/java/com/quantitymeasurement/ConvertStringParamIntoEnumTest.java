package com.quantitymeasurement;

import com.quantitymeasurement.model.IUnit;
import com.quantitymeasurement.model.UnitOfLength;
import com.quantitymeasurement.service.ConvertStringParameterIntoEnum;
import com.quantitymeasurement.service.QuantityMeasurement;
import com.quantitymeasurement.service.QuantityMeasurementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConvertStringParamIntoEnumTest {

    @Mock
    QuantityMeasurement quantityMeasurement;
    @InjectMocks
    ConvertStringParameterIntoEnum stringParameterIntoEnum;

    @Before
    public void setUp() throws Exception {
        quantityMeasurement = mock(QuantityMeasurement.class);
        stringParameterIntoEnum = mock(ConvertStringParameterIntoEnum.class);
    }

    @Test
    public void name() {
        try {
            when(quantityMeasurement.compare(UnitOfLength.INCH,2.0,UnitOfLength.INCH,2.0)).thenReturn(true);
            String doCompare = stringParameterIntoEnum.doCompare("INCH", 2.0, "INCH", 2.0);
            Assert.assertEquals("is "+2.0 +"INCH equal to " + 2.0 +"INCH ? :",doCompare);
        } catch (QuantityMeasurementException e) {
            e.printStackTrace();
        }
    }
}
