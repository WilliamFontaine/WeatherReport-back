package fr.hesias.WeatherReport.Repository;

import fr.hesias.WeatherReport.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}