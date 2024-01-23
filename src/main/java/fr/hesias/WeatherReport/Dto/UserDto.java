package fr.hesias.WeatherReport.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link fr.hesias.WeatherReport.Model.User}
 */
@Getter
@Setter
public class UserDto implements Serializable {
    private UUID id;

    @NotNull
    @Size(min = 1, max = 255)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 255)
    private String lastName;
}