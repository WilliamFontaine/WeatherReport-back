package fr.hesias.WeatherReport.Repository;

import fr.hesias.WeatherReport.Model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {

    @Query(value = "SELECT * FROM report r " +
            "WHERE created_at > NOW() - INTERVAL '1 day' " +
            "AND 6371 * acos(cos(radians(?1)) * cos(radians(r.latitude)) * cos(radians(r.longitude) - radians(?2)) + sin(radians(?1)) * sin(radians(r.latitude))) < ?3 " +
            "ORDER BY 6371 * acos(cos(radians(?1)) * cos(radians(r.latitude)) * cos(radians(r.longitude) - radians(?2)) + sin(radians(?1)) * sin(radians(r.latitude))), created_at DESC ",
            nativeQuery = true)
    Page<Report> findInRadius(BigDecimal latitude, BigDecimal longitude, Integer radius, Pageable pageable);
}
