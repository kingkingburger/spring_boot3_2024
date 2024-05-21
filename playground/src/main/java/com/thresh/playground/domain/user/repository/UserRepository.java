package com.thresh.playground.domain.user.repository;

import com.thresh.playground.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findUserByLoginId(String loginId);

  Optional<User> findByUsername(String userName);
}
