package fr.hesias.WeatherReport.Mapper;

import fr.hesias.WeatherReport.Dto.UserDto;
import fr.hesias.WeatherReport.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends BaseMapper<User, UserDto> {

    @Override
    User dtoToEntity(UserDto dto);

    @Override
    UserDto entityToDto(User entity);

    @Override
    List<User> dtoToEntities(List<UserDto> dtos);

    @Override
    List<UserDto> entityToDtos(List<User> entities);
}
