package fr.hesias.WeatherReport.Controller;

import fr.hesias.WeatherReport.Dto.UserDto;
import fr.hesias.WeatherReport.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll() {
        List<UserDto> userDtoList = userService.findAll();
        if (userDtoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") UUID id) {
        Optional<UserDto> userDto = userService.findById(id);
        if (userDto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserDto userDto) {
        UserDto userDtoCreated = userService.create(userDto);
        return ResponseEntity.ok(userDtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        UserDto userDtoUpdated = userService.update(id, userDto);
        return ResponseEntity.ok(userDtoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
