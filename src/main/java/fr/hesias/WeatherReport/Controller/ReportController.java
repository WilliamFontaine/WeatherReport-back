package fr.hesias.WeatherReport.Controller;

import fr.hesias.WeatherReport.Dto.ReportDto;
import fr.hesias.WeatherReport.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("?lat={lat}&lon={lon}&radius={radius}")
    public ResponseEntity getInRadius(@PathVariable("lat") double lat, @PathVariable("lon") double lon, @PathVariable("radius") int radius) {
        List<ReportDto> reportDtoList = reportService.findInRadius(lat, lon, radius);
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
