package com.sparta.lt.northwindrest.data.mappingservices;

import com.sparta.lt.northwindrest.data.dto.TerritoryDTO;
import com.sparta.lt.northwindrest.entities.TerritoryEntity;
import com.sparta.lt.northwindrest.repositories.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerritoryMapService {
    @Autowired
    private TerritoryRepository territoryRepository;

    public List<TerritoryDTO> getAllTerritoryDTO() {
        return territoryRepository.findAll()
                .stream()
                .map(this::convertTerritoryEntityToTerritoryDTO)
                .collect(Collectors.toList());
    }

    public List<TerritoryDTO> getTerritoryById(String territoryId) {
        return territoryRepository.findAll()
                .stream()
                .filter(territoryEntity -> territoryEntity.getId().equals(territoryId))
                .map(this::convertTerritoryEntityToTerritoryDTO)
                .collect(Collectors.toList());
    }

    public List<TerritoryDTO> getTerritoryByName(String territoryName) {
        return territoryRepository.findAll()
                .stream()
                .filter(territoryEntity -> territoryEntity.getTerritoryDescription().contains(territoryName))
                .map(this::convertTerritoryEntityToTerritoryDTO)
                .collect(Collectors.toList());
    }

    public List<TerritoryDTO> getTerritoriesByRegion(String regionName) {
        return territoryRepository.findAll()
                .stream()
                .filter(territoryEntity -> territoryEntity.getRegionID().getRegionDescription().contains(regionName))
                .map(this::convertTerritoryEntityToTerritoryDTO)
                .collect(Collectors.toList());
    }
    
    private TerritoryDTO convertTerritoryEntityToTerritoryDTO(TerritoryEntity territoryEntity) {
        TerritoryDTO territoryDTO = new TerritoryDTO();
        territoryDTO.setTerritoryId(territoryEntity.getId());
        territoryDTO.setTerritoryName(territoryEntity.getTerritoryDescription());
        territoryDTO.setRegionName(territoryEntity.getRegionID().getRegionDescription());
        return territoryDTO;
    }
}
