package me.dio.bradesco_bootcamp_2025.domain.repository;

import me.dio.bradesco_bootcamp_2025.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
