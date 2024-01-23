package fr.hesias.WeatherReport.Repository;

import fr.hesias.WeatherReport.Dto.ReportDto;
import fr.hesias.WeatherReport.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {


    @Query(value = "SELECT * FROM report WHERE report_date > NOW() - INTERVAL '1 DAY'", nativeQuery = true)
    List<ReportDto> findLastDay();

    @Query(value = "SELECT * FROM Report r WHERE " +
            "(6371 * acos(cos(?1/(180/ACOS(-1))) * cos(r.latitude/(180/ACOS(-1))) * cos(r.longitude/(180/ACOS(-1)) - ?2/(180/ACOS(-1))) + sin(?1/(180/ACOS(-1))) * sin(r.latitude/(180/ACOS(-1))))) <= ?3 " +
            "AND report_date > NOW() - INTERVAL '1 DAY'", nativeQuery = true)
    List<ReportDto> findInRadius(double lat, double lon, double radius);
}
