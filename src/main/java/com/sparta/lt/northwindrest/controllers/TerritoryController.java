package com.sparta.lt.northwindrest.controllers;

import com.sparta.lt.northwindrest.data.dto.TerritoryDTO;
import com.sparta.lt.northwindrest.data.mappingservices.TerritoryMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TerritoryController {
    private final TerritoryMapService territoryMapService;

    @Autowired
    TerritoryController(TerritoryMapService territoryMapService) {
        this.territoryMapService = territoryMapService;
    }

    @GetMapping("/northwind/territories")
    public List<TerritoryDTO> getAllTerritories() {
        return territoryMapService.getAllTerritoryDTO();
    }

    @GetMapping("/northwind/territories/{territoryId}")
    public List<TerritoryDTO> getTerritoriesById(@PathVariable String territoryId) {
        return territoryMapService.getTerritoryById(territoryId);
    }

    @GetMapping(value="/northwind/territories", params={"name"})
    public List<TerritoryDTO> getTerritoriesByName(@RequestParam String territoryName) {
        return territoryMapService.getTerritoryByName(territoryName);
    }

    @GetMapping(value="/northwind/territories", params={"region"})
    public List<TerritoryDTO> getTerritoriesByRegion(@RequestParam String regionName) {
        return territoryMapService.getTerritoriesByRegion(regionName);
    }

}
