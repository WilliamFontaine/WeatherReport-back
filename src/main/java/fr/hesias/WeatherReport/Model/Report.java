package fr.hesias.WeatherReport.Model;

import fr.hesias.WeatherReport.Enum.WeatherType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "report_date")
    private Timestamp reportDate;

    @Column(name = "latitude", nullable = false)
    private Long latitude;

    @Column(name = "longitude", nullable = false)
    private Long longitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_type", nullable = false)
    private WeatherType weatherType;

    @Column(name = "temperature", nullable = false)
    private Long temperature;
}

