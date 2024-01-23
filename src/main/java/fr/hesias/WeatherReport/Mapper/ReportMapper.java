package fr.hesias.WeatherReport.Mapper;

import fr.hesias.WeatherReport.Dto.ReportDto;
import fr.hesias.WeatherReport.Model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface ReportMapper extends BaseMapper<Report, ReportDto> {

        @Override
        Report dtoToEntity(ReportDto dto);

        @Override
        ReportDto entityToDto(Report entity);

        @Override
        List<Report> dtoToEntities(List<ReportDto> dtos);

        @Override
        List<ReportDto> entityToDtos(List<Report> entities);
}
