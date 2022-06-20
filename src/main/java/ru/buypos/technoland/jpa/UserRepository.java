package ru.buypos.technoland.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buypos.technoland.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByKey (String token);
}