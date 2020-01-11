package com.quantitymeasurement;

import com.quantitymeasurement.model.IUnit;
import com.quantitymeasurement.model.UnitOfLength;
import com.quantitymeasurement.service.QuantityMeasurement;
import com.quantitymeasurement.service.QuantityMeasurementException;
import com.quantitymeasurement.service.UnitContainer;
import com.quantitymeasurement.service.doStuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/quantityMeasurement")
public class QuantityMeasurementController {

    @Autowired
    doStuff doStuff;

    @GetMapping("/compare")
    public String compareUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "val1") Double val1,
                               @RequestParam(value = "unit2") String unit2, @RequestParam(value = "val2") Double val2) {

        return doStuff.doCompare(unit1, val1, unit2, val2);
    }

    @GetMapping("/add")
    public String addUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "val1") Double val1,
                           @RequestParam(value = "unit2") String unit2, @RequestParam(value = "val2") Double val2) {

        return doStuff.doAdd(unit1, val1, unit2, val2);
    }
}
