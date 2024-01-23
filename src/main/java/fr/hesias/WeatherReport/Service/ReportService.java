package fr.hesias.WeatherReport.Service;

import fr.hesias.WeatherReport.Dto.ReportDto;
import fr.hesias.WeatherReport.Mapper.ReportMapper;
import fr.hesias.WeatherReport.Model.Report;
import fr.hesias.WeatherReport.Repository.ReportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportService extends BaseService<Report, ReportDto> {

    private final ReportRepository repository;

    private final ReportMapper mapper;

    public ReportService(ReportRepository repository, ReportMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<ReportDto> findInRadius(BigDecimal latitude, BigDecimal longitude, Integer radius, Pageable pageable) {
        Page<Report> reportList = repository.findInRadius(latitude, longitude, radius, pageable);
        return reportList.map(mapper::entityToDto);
    }
}
