package com.life_insurance_system.repository;

import com.life_insurance_system.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query("SELECT a FROM Application a JOIN FETCH a.user u JOIN FETCH u.role WHERE a.applicationId = :id")
    Optional<Application> findByIdWithUserAndRole(@Param("id") int id);
}