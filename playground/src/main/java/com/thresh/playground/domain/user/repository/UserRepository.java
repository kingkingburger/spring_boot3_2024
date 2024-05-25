package com.thresh.playground.domain.user.repository;

import com.thresh.playground.domain.user.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User2, Long> {
  //  Optional<User> findUserByLoginId(String loginId);

  Optional<User2> findByUsername(String userName);
}
