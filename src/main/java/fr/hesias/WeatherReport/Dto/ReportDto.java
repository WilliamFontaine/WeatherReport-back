package fr.hesias.WeatherReport.Dto;

import fr.hesias.WeatherReport.Enum.WeatherType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


/**
 * DTO for {@link fr.hesias.WeatherReport.Model.Report}
 */
@Getter
@Setter
public class ReportDto implements Serializable {
    private UUID id;

    @NotNull
    private BigDecimal latitude;

    @NotNull
    private BigDecimal longitude;

    @NotNull
    private WeatherType weatherType;

    @NotNull
    private BigDecimal temperature;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}