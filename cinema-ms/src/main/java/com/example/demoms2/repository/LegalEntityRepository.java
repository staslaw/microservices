package com.example.demoms2.repository;

import com.example.demoms2.model.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalEntityRepository extends JpaRepository<LegalEntity, Long> {
}
