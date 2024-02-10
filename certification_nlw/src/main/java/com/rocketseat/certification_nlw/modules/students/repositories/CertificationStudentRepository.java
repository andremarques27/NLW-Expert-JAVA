package com.rocketseat.certification_nlw.modules.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.UUID;

import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudentEntity;

public interface CertificationStudentRepository  extends JpaRepository<CertificationStudentEntity, UUID>{
    
    @Query("SELECT c FROM certification c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);

    @Query("SELECT c from certifications c ORDER BY c.grade DESC LIMIT 10")
    List<CertificationStudentEntity> findTop10ByOrderByGradeDesc();

}
