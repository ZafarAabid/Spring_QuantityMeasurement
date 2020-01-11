package com.quantitymeasurement.service;


import com.quantitymeasurement.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UnitContainer {

    public UnitContainer() {
        unitMap = new HashMap<>();
        getReadyAllUnits();
    }
    Map<String, IUnit> unitMap;

    private void getReadyAllUnits() {
        Arrays.stream(UnitOfLength.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(), unitOfLength));
        Arrays.stream(UnitOfVolume.values()).forEach(UnitOfVolume -> unitMap.put(UnitOfVolume.name().trim(), UnitOfVolume));
        Arrays.stream(UnitOfWeights.values()).forEach(UnitOfWeights -> unitMap.put(UnitOfWeights.name().trim(), UnitOfWeights));
        Arrays.stream(UnitOfTemperature.values()).forEach(UnitOfTemperature -> unitMap.put(UnitOfTemperature.name().trim(), UnitOfTemperature));
    }

    public IUnit getUnit(String unit) {
        return unitMap.get(unit.toUpperCase());
    }
}

