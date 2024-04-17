package com.mysite.sbb.company.repository;

import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.item.entity.Item;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * "org.springframework.data.repository.query.Param.value()" because the return value of "java.lang.reflect.Parameter.getAnnotation(java.lang.Class)" is null 에러나서
 * @Hidden으로 swagger에서 jpa를 인식하지 못하게 함
 */
@Hidden
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
