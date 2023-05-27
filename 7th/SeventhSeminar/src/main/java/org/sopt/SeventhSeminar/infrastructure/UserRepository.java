package org.sopt.SeventhSeminar.infrastructure;

import org.sopt.SeventhSeminar.domain.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
