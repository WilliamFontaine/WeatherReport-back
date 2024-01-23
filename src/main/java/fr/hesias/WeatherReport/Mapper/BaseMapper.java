package fr.hesias.WeatherReport.Mapper;


import java.util.List;

public interface BaseMapper<ENTITY, DTO> {

    ENTITY dtoToEntity(DTO dto);

    DTO entityToDto(ENTITY entity);

    List<ENTITY> dtoToEntities(List<DTO> dtos);

    List<DTO> entityToDtos(List<ENTITY> entities);
}
