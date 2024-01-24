package com.mysite.sbb.awb.repository;

import com.mysite.sbb.awb.domain.Awb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwbRepository extends JpaRepository<Awb, Long> {
}
