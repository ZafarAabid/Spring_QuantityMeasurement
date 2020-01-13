package com.quantitymeasurement;

import com.quantitymeasurement.model.ParameterBody;
import com.quantitymeasurement.service.ConvertStringParameterIntoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quantityMeasurement")
public class QuantityMeasurementController {

    //GRAM   KILOGRAM   TONNE  --  CENTI_METER   INCH  FEET   YARD  --  MILLI_LITRE   LITRE   GALLON  --  FAHRENHEIT   CELSIUS

    @Autowired
    ConvertStringParameterIntoEnum parameterIntoEnum;

    @GetMapping("/compareByParam")
    public String compareUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "val1") Double val1,
                               @RequestParam(value = "unit2") String unit2, @RequestParam(value = "val2") Double val2) {
        return parameterIntoEnum.doCompare(unit1, val1, unit2, val2);
    }
    @GetMapping("/compareByBody")
    public String compareUnits(@RequestBody ParameterBody paramBody) {
        return parameterIntoEnum.doCompareByBody(paramBody);
    }

    @GetMapping("/addByParam")
    public String addUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "val1") Double val1,
                           @RequestParam(value = "unit2") String unit2, @RequestParam(value = "val2") Double val2) {
        return parameterIntoEnum.doAdd(unit1, val1, unit2, val2);
    }
    @GetMapping("/addByBody")
    public String addUnits(@RequestBody ParameterBody paramBody) {
        return parameterIntoEnum.doAddByBody(paramBody);
    }
}
