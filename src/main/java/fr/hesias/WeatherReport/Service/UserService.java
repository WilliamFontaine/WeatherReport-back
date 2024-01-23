package fr.hesias.WeatherReport.Service;

import fr.hesias.WeatherReport.Dto.UserDto;
import fr.hesias.WeatherReport.Mapper.UserMapper;
import fr.hesias.WeatherReport.Model.User;
import fr.hesias.WeatherReport.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDto> {

    private final UserRepository repository;

    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
