package fr.hesias.WeatherReport.Controller;

import fr.hesias.WeatherReport.Dto.ReportDto;
import fr.hesias.WeatherReport.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity getInRadius(
            @RequestParam("latitude") BigDecimal latitude,
            @RequestParam("longitude") BigDecimal longitude,
            @RequestParam(name = "radius", defaultValue = "100") Integer radius,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size
    ) {
        if (radius > 100) {
            return ResponseEntity.badRequest().body("Radius must be less than 100km");
        }
        if (latitude.compareTo(new BigDecimal("90")) > 0 || latitude.compareTo(new BigDecimal("-90")) < 0) {
            return ResponseEntity.badRequest().body("Latitude must be between -90 and 90");
        }
        if (longitude.compareTo(new BigDecimal("180")) > 0 || longitude.compareTo(new BigDecimal("-180")) < 0) {
            return ResponseEntity.badRequest().body("Longitude must be between -180 and 180");
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<ReportDto> reportDtoList = reportService.findInRadius(latitude, longitude, radius, pageable);
        if (reportDtoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportDtoList);
    }


    @PostMapping
    public ResponseEntity create(@RequestBody ReportDto reportDto) {
        ReportDto reportDtoCreated = reportService.create(reportDto);
        return ResponseEntity.ok(reportDtoCreated);
    }
}
