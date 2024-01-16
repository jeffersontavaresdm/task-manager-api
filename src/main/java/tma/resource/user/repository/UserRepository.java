package tma.resource.user.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tma.resource.user.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "INSERT INTO users (username, password) VALUES (:username, :password) RETURNING users.*")
    Optional<User> createUser(@Param("username") String username, @Param("password") String password);
}