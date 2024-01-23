package fr.hesias.WeatherReport.Dto;

import fr.hesias.WeatherReport.Enum.WeatherType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link fr.hesias.WeatherReport.Model.Report}
 */
@Getter
@Setter
public class ReportDto implements Serializable {
    private UUID id;

    @NotNull
    private Timestamp reportDate;

    @NotNull
    private Long latitude;

    @NotNull
    private Long longitude;

    @NotNull
    private WeatherType weatherType;

    @NotNull
    private Long temperature;
}