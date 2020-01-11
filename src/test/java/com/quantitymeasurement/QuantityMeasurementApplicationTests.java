package com.quantitymeasurement;

import com.quantitymeasurement.model.IUnit;
import com.quantitymeasurement.service.UnitContainer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class QuantityMeasurementApplicationTests {

    @Test
    void contextLoads() {
        UnitContainer container = new UnitContainer();
        IUnit unit = container.getUnit("GALLON");
        Assert.notNull(unit,"successful");
    }

}
